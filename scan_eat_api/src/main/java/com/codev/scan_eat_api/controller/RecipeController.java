package com.codev.scan_eat_api.controller;

import com.codev.scan_eat_api.entities.Recipe;
import com.codev.scan_eat_api.repository.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(path = "/")
public class RecipeController implements ErrorController {

    final RecipeDao recipeDao;

    @Autowired
    public RecipeController(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    @GetMapping(path = "/recipes")
    private Iterable<Recipe> allRecipes() {
        return recipeDao.findAll();
    }


    @GetMapping(path = "/recipes/{id}")
    //@RequestMapping(value = "/recipes", params = "id", method = GET)
    private ResponseEntity<Recipe> recipe(@PathVariable int id) {
        Optional<Recipe> recipe = recipeDao.findById(id);
        if(recipe.isPresent()) {
            return ResponseEntity.accepted().body(recipe.get());
        } else {
            return ResponseEntity.notFound().build();
            //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe Not Found");
        }
        //return recipeDao.findAll();
    }

    private final static String PATH = "/error";
    @Override
    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return "No Mapping Found";
    }

}