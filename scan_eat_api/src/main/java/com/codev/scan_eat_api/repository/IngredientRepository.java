package com.codev.scan_eat_api.repository;

import com.codev.scan_eat_api.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    Optional<Ingredient> findByBarcode(long barcode);

    boolean existsByBarcode(long barcode);
}
