package com.codev.scan_eat_api.controller.securedcontrollers;

import com.codev.scan_eat_api.entities.recipe.Recipe;
import com.codev.scan_eat_api.entities.User;
import com.codev.scan_eat_api.entities.recipe.RecipeContent;
import com.codev.scan_eat_api.entities.recipe.RecipeContentIdentity;
import com.codev.scan_eat_api.exceptions.ScanEatException;
import com.codev.scan_eat_api.repository.*;
import com.codev.scan_eat_api.repository.RecipeIngredientRepository;
import com.codev.scan_eat_api.security.UserAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping(value={"public/recipes", "recipes"}) //public/ingredient is only for testing
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class SecuredRecipeController {
    @NonNull
    private UserAuthenticationService authentication;

    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final RecipeIngredientRepositoryOld recipeIngredientRepositoryOld;
    private final UnitRepository unitRepository;

    @GetMapping("/all")
    ResponseEntity<Object> all(@AuthenticationPrincipal final User user) {
        return ResponseEntity.ok().body(recipeRepository.findAll().get(0));
    }

    final private RecipeIngredientRepository recipeIngredientRepository;

    @PutMapping("/create")
    ResponseEntity<Object> create(@AuthenticationPrincipal User user, @RequestBody Recipe recipe) throws ScanEatException {

        RecipeContent c = new RecipeContent();
        //c.setName(c.getName());
        //c.setFilm(f);
        //c.setActor(actorDao.findById(c.getActor().getId()));

        //int i = f.getId();
        //Actor a =c.getActor();
        //int ia = a.getId();
        long barcode = Long.parseLong("3029330003533");
        c.setQuantity(100f);
        RecipeContentIdentity cId = new RecipeContentIdentity(1, barcode);

        c.setId_casting(cId);
        c.setIdUnit(1);
        recipeIngredientRepository.save(c);



        /*if(user == null) {
            user = userRepository.findAll().get(0);
        }

        List<RecipeContentOld> ingredients = recipe.getIngredients();
        recipe.setIngredients(new ArrayList<>());
        recipe.setId(null);
        recipe.setOwner(user.getUsername());
        recipeRepository.save(recipe);

        recipe.setIngredients(ingredients);
        long barcode = Long.parseLong("3029330003533");
        RecipeContentOld recipeContent = new RecipeContentOld();

        recipeContent.setRecipe(recipeRepository.findById(2).get());
        recipeContent.setIngredient$(ingredientRepository.findByBarcode(barcode).get());

        RecipeContentIdentityOld recipeContentIdentity = new RecipeContentIdentityOld(2, 300);
        recipeContent.setRecipeContentIdentityOld(recipeContentIdentity);

        recipeIngredientRepository.save(recipeContent);
        /*for(RecipeContentOld content : ingredients)
        {
            recipeIngredientRepository.save(
                    new RecipeContentOld(
                            recipe.getId(),
                            3029330003533//content.getBarcode(),
                            content.getQuantity(),
                            0//content.getIdUnit()
                    )
            );
        }*/


        //recipeRepository.save(recipe);
        return ResponseEntity.ok().body(recipe);
    }

    /*private void initIngredients(Recipe recipe) throws ScanEatException {
        for(RecipeContentOld content : recipe.getIngredients())
        {
            Optional<Ingredient> ingredientOpt = ingredientRepository.findByBarcode(content.getBarcode());
            if(!ingredientOpt.isPresent()) {
                ExceptionGenerator.ingredientNotFound(content.getBarcode());
            }
            //content.setIdRecipe(recipe.getId());
            //content.setIngredient(ingredientOpt.get());
        }
    }*/

    @ExceptionHandler({ScanEatException.class})
    public ResponseEntity<Object> onScanEatException(HttpServletRequest req, ScanEatException ex) {
        return ex.getResponseEntity();
    }
}
