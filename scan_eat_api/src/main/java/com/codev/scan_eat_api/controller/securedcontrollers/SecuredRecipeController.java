package com.codev.scan_eat_api.controller.securedcontrollers;

import com.codev.scan_eat_api.entities.recipe.Recipe;
import com.codev.scan_eat_api.entities.User;
import com.codev.scan_eat_api.entities.recipe.RecipeContent;
import com.codev.scan_eat_api.exceptions.ExceptionGenerator;
import com.codev.scan_eat_api.exceptions.ScanEatException;
import com.codev.scan_eat_api.repository.*;
import com.codev.scan_eat_api.repository.RecipeIngredientRepository;
import com.codev.scan_eat_api.security.UserAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        return ResponseEntity.ok().body(recipeRepository.findAll());
    }

    final private RecipeIngredientRepository recipeIngredientRepository;

    @PutMapping("/create")
    ResponseEntity<Object> create(@AuthenticationPrincipal User user, @RequestBody Recipe recipe) throws ScanEatException {
        if(user == null) {
            user = userRepository.findAll().get(0);
        }
        verifyRecipeContent(recipe);

        List<RecipeContent> ingredients = recipe.getIngredients();
        recipe.setIngredients(new ArrayList<>());
        recipe.setId(null);
        recipe.setOwner(user.getUsername());
        recipeRepository.saveAndFlush(recipe);

        for(RecipeContent content : ingredients)
        {
            recipeIngredientRepository.save(
                    new RecipeContent(
                            recipe.getId(),
                            content.getIngredientBarcode(),
                            content.getQuantity(),
                            content.getIdUnit()
                    )
            );
        }

        recipeRepository.flush();
        recipeIngredientRepository.flush();

        return ResponseEntity.ok().build();
    }

    private void verifyRecipeContent(Recipe recipe) throws ScanEatException {
        for(RecipeContent content : recipe.getIngredients())
        {
            if(!ingredientRepository.existsByBarcode(content.getIngredientBarcode())) {
                ExceptionGenerator.ingredientNotFound(content.getIngredientBarcode());
            }
            if(!unitRepository.existsById(content.getIdUnit())) {
                ExceptionGenerator.unitNotFound(content.getIdUnit());
            }
        }
    }

    @ExceptionHandler({ScanEatException.class})
    public ResponseEntity<Object> onScanEatException(HttpServletRequest req, ScanEatException ex) {
        return ex.getResponseEntity();
    }
}
