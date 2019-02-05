package com.codev.scan_eat_api.controller.securedcontrollers;

import com.codev.scan_eat_api.entities.Ingredient;
import com.codev.scan_eat_api.entities.Unit;
import com.codev.scan_eat_api.entities.recipe.Recipe;
import com.codev.scan_eat_api.entities.User;
import com.codev.scan_eat_api.entities.recipe.RecipeContent;
import com.codev.scan_eat_api.entities.recipe.RecipeContentIdentity;
import com.codev.scan_eat_api.exceptions.ExceptionGenerator;
import com.codev.scan_eat_api.exceptions.ScanEatException;
import com.codev.scan_eat_api.repository.*;
import com.codev.scan_eat_api.security.UserAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final UnitRepository unitRepository;

    @GetMapping("/all")
    ResponseEntity<Object> all(@AuthenticationPrincipal final User user) {
        return ResponseEntity.ok().body(recipeRepository.findAll().get(0));
    }

    @PutMapping("/create")
    ResponseEntity<Object> create(@AuthenticationPrincipal User user, @RequestBody Recipe recipe) throws ScanEatException {
        if(user == null) {
            user = userRepository.findAll().get(0);
        }

        List<RecipeContent> ingredients = recipe.getIngredients();
        recipe.setIngredients(new ArrayList<>());
        recipe.setId(null);
        recipe.setOwner(user.getUsername());
        recipeRepository.save(recipe);

        recipe.setIngredients(ingredients);

        for(RecipeContent content : ingredients)
        {
            recipeIngredientRepository.save(
                    new RecipeContent(
                            recipe.getId(),
                            content.getBarcode(),
                            content.getQuantity(),
                            0//content.getIdUnit()
                    )
            );
        }


        //recipeRepository.save(recipe);
        return ResponseEntity.ok().body(recipe);
    }

    private void initIngredients(Recipe recipe) throws ScanEatException {
        for(RecipeContent content : recipe.getIngredients())
        {
            Optional<Ingredient> ingredientOpt = ingredientRepository.findByBarcode(content.getBarcode());
            if(!ingredientOpt.isPresent()) {
                ExceptionGenerator.ingredientNotFound(content.getBarcode());
            }
            //content.setIdRecipe(recipe.getId());
            //content.setIngredient(ingredientOpt.get());
        }
    }

    @ExceptionHandler({ScanEatException.class})
    public ResponseEntity<Object> onScanEatException(HttpServletRequest req, ScanEatException ex) {
        return ex.getResponseEntity();
    }
}
