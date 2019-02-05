package com.codev.scan_eat_api.entities.recipe;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Table(name = "recipe_ingredient")
public class RecipeContentIdentityOld implements Serializable {

    @Column(name = "id_recipe")
    private int idRecipe;

    @Column(name = "barcode_ingredient")
    private int barcodeIngredient;

    public RecipeContentIdentityOld() {
    }

    public RecipeContentIdentityOld(int idRecipe, int barcodeIngredient) {
        this.idRecipe = idRecipe;
        this.barcodeIngredient = barcodeIngredient;
    }

    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }

    public int getBarcodeIngredient() {
        return barcodeIngredient;
    }

    public void setBarcodeIngredient(int barcodeIngredient) {
        this.barcodeIngredient = barcodeIngredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeContentIdentityOld that = (RecipeContentIdentityOld) o;
        return idRecipe == that.idRecipe &&
                barcodeIngredient == that.barcodeIngredient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecipe, barcodeIngredient);
    }
}
