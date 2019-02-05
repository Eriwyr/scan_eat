package com.codev.scan_eat_api.controller.securedcontrollers;

import com.codev.scan_eat_api.entities.recipe.Recipe;
import com.codev.scan_eat_api.entities.User;
import com.codev.scan_eat_api.repository.RecipeRepository;
import com.codev.scan_eat_api.repository.UserRepository;
import com.codev.scan_eat_api.security.UserAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping(value={"public/recipes", "recipes"}) //public/ingredient is only for testing
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class SecuredRecipeController {
    @NonNull
    private UserAuthenticationService authentication;

    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

    @GetMapping("/all")
    ResponseEntity<Object> all(@AuthenticationPrincipal final User user) {
        return ResponseEntity.ok().body(recipeRepository.findAll().get(0));
    }

    @PutMapping("/create")
    ResponseEntity<Object> create(@AuthenticationPrincipal User user, @RequestBody Recipe recipe) {
        if(user == null) {
            user = userRepository.findAll().get(0);
        }


        return ResponseEntity.ok().body(recipeRepository.findAll().get(0));
    }
}
