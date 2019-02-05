package com.codev.scan_eat_api.repository;


import com.codev.scan_eat_api.entities.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
