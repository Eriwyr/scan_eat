package com.codev.scan_eat_api.controller;

import com.codev.scan_eat_api.entities.Recipe;
import com.codev.scan_eat_api.repository.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class RecipeController {

    final RecipeDao recipeDao;

    @Autowired
    public RecipeController(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    @GetMapping(path = "/recipes")
    private Iterable<Recipe> allRecipes() {
        return recipeDao.findAll();
    }
}