package com.codev.scan_eat_api.repository;

import com.codev.scan_eat_api.entities.recipe.RecipeContentOld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepositoryOld extends JpaRepository<RecipeContentOld, Integer> {
}
