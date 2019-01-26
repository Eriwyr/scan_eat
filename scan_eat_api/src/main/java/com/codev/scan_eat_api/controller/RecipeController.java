package com.codev.scan_eat_api.controller;

import com.codev.scan_eat_api.entities.Recipe;
import com.codev.scan_eat_api.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping(path = "/recipes")
@ResponseBody

public class RecipeController {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping(path = "")
    private Iterable<Recipe> allRecipes() {
        return recipeRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<Recipe> recipe(@PathVariable int id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.map(r
                -> ResponseEntity.accepted().body(r)).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "")
    public ResponseEntity<?> bulkCreationRecipes(UriComponentsBuilder b) {

        UriComponents uriComponents = b.path("").build();

        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    //TODO : pagination

}