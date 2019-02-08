package com.codev.scan_eat_api.controller.securedcontrollers;

import com.codev.scan_eat_api.GeneralResponses;
import com.codev.scan_eat_api.Utils;
import com.codev.scan_eat_api.entities.Additive;
import com.codev.scan_eat_api.entities.ingredient.Ingredient;
import com.codev.scan_eat_api.entities.Unit;
import com.codev.scan_eat_api.entities.ingredient.IngredientAdditive;
import com.codev.scan_eat_api.exceptions.ExceptionGenerator;
import com.codev.scan_eat_api.exceptions.ScanEatException;
import com.codev.scan_eat_api.repository.AdditiveRepository;
import com.codev.scan_eat_api.repository.IngredientAdditiveRepository;
import com.codev.scan_eat_api.repository.IngredientRepository;
import com.codev.scan_eat_api.repository.UnitRepository;
import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping(value={"public/ingredients", "ingredients"}) //public/ingredient is only for testing
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class SecuredIngredientController {
    private long timeBetweenRefreshes = 3600000; //Time in milliseconds between an ingredient should be reverified in the foodfact database
    private final IngredientRepository ingredientRepository;
    private final UnitRepository unitRepository;
    private final AdditiveRepository additiveRepository;
    private final IngredientAdditiveRepository ingredientAdditiveRepository;
    /*@NonNull
    private UserAuthenticationService authentication;*/

    @GetMapping("/find")
    ResponseEntity<Object> find(@RequestParam("barcode") final long barcode) throws ScanEatException {
        try {
            Optional<Ingredient> ingredientOpt = ingredientRepository.findByBarcode(barcode);
            Ingredient ingredient = null;
            if(ingredientOpt.isPresent() && ingredientOpt.get().getLastRefresh()+timeBetweenRefreshes > System.currentTimeMillis())
            {
                ingredient = ingredientOpt.get();
            }
            if(ingredient == null)
            {
                ingredient = new Ingredient();
                try {
                    JSONObject jsonIngredient = Utils.getJsonResponseFromUrlStr("https://fr.openfoodfacts.org/api/v0/produit/" + barcode + ".json");
                    ingredient.setBarcode(jsonIngredient.getLong("code"));
                    ingredient.setName(jsonIngredient.getJSONObject("product").getString("product_name"));
                    ingredient.setLastRefresh(System.currentTimeMillis());
                    String quantityStr = jsonIngredient.getJSONObject("product").getString("quantity");
                    Optional<Unit> unit = getUnitByMapping(jsonIngredient.getJSONObject("product").getString("quantity"));
                    if(unit.isPresent()) {
                        ingredient.setUnit(unit.get());
                    } else {
                        ExceptionGenerator.ingredientUnitMappingNotFound(barcode, quantityStr);
                    }

                    JSONObject nutriments = jsonIngredient.getJSONObject("product").getJSONObject("nutriments");
                    ingredient.setKcal100g((int)Math.round((nutriments.has("energy_100g") ? nutriments.getDouble("energy_100g") : 0)*0.239006));
                    ingredient.setProteins100g(nutriments.has("proteins_100g") ? nutriments.getDouble("proteins_100g") : 0);
                    ingredient.setSugars100g(nutriments.has("sugars_100g") ? nutriments.getDouble("sugars_100g") : 0);
                    ingredient.setFat100g(nutriments.has("fat_100g") ? nutriments.getDouble("fat_100g") : 0);
                    ingredient.setSalt100g(nutriments.has("salt_100g") ? nutriments.getDouble("salt_100g") : 0);
                    ingredient.setFiber100g(nutriments.has("fiber_100g") ? nutriments.getDouble("fiber_100g") : 0);
                    ingredient.setImageUrl(jsonIngredient.getJSONObject("product").getString("image_front_url"));

                    ingredient.setAdditives(new ArrayList<>());
                    ingredient.setAdditiveTags(new ArrayList<>());
                    Ingredient finalIngredient = ingredient;
                    jsonIngredient.getJSONObject("product").getJSONArray("additives_tags")
                            .toList().forEach(at -> {
                                String additiveId = ((String)at).toUpperCase();
                                if(additiveId.contains(":")) {
                                    additiveId = additiveId.substring(additiveId.indexOf(":")+1);
                                }
                                if(!additiveRepository.existsById(additiveId)) {
                                    additiveRepository.save(new Additive(additiveId));
                                }
                                System.out.println(additiveId);
                                finalIngredient.getAdditives().add(new IngredientAdditive(finalIngredient.getBarcode(), additiveId));
                                finalIngredient.getAdditiveTags().add(additiveId);
                            });

                } catch(JSONException e) {
                    ExceptionGenerator.ingredientDetailsLacking(barcode, e);
                }
                ingredientRepository.save(ingredient);
            }

            ingredient.setPossibleUnits(
                    unitRepository.findAllByBaseUnit(
                            ingredient.getUnit().getBaseUnit())
                            .stream()
                            .map(o -> new Pair<>(o.getId(), o.getName()))
                            .filter(o -> o.getKey() != 3)
                            .collect(Collectors.toList())
            );

            return ResponseEntity.ok().body(ingredient);
        } catch (IOException e) {
            e.printStackTrace();
            return GeneralResponses.internalServerError();
        }
    }

    private Optional<Unit> getUnitByMapping(String str) {
        for(Unit unit : unitRepository.findAll())
        {
            if(str.matches(unit.getMapping()))
            {
                return Optional.of(unit);
            }
        }
        return Optional.empty();
    }

    @ExceptionHandler({ScanEatException.class})
    public ResponseEntity<Object> onScanEatException(HttpServletRequest req, ScanEatException ex) {
        return ex.getResponseEntity();
    }
}
