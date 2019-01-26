package com.codev.scan_eat_api.controller;

import com.codev.scan_eat_api.entities.Recipe;
import com.codev.scan_eat_api.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(path = "/")
@ResponseBody
public class RecipeController {

    final RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping(path = "/recipes")
    private Iterable<Recipe> allRecipes() {
        return recipeRepository.findAll();
    }


    @GetMapping(path = "/recipes/{id}")
    private ResponseEntity<Recipe> recipe(@PathVariable int id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(recipe.isPresent()) {
            return ResponseEntity.accepted().body(recipe.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}