package com.codev.scan_eat_api.repository;

import com.codev.scan_eat_api.entities.ingredient.IngredientAdditive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IngredientAdditiveRepository extends JpaRepository<IngredientAdditive, Integer> {

}