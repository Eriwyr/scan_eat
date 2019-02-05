package com.codev.scan_eat_api.repository;

import com.codev.scan_eat_api.entities.recipe.RecipeContent;
import com.codev.scan_eat_api.entities.recipe.RecipeContentIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeContent, Integer> {
}
