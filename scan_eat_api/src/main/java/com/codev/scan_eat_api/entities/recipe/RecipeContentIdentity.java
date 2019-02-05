package com.codev.scan_eat_api.entities.recipe;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeContentIdentity implements Serializable {

    @Column(name = "id_recipe")
    private int idRecipe;


    @Column(name = "barcode_ingredient")
    private long barcodeIngredient;

    public RecipeContentIdentity(int idRecipe, long barcodeIngredient) {
        this.idRecipe = idRecipe;
        this.barcodeIngredient = barcodeIngredient;
    }

    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }

    public long getBarcodeIngredient() {
        return barcodeIngredient;
    }

    public void setBarcodeIngredient(long barcodeIngredient) {
        this.barcodeIngredient = barcodeIngredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeContentIdentity that = (RecipeContentIdentity) o;
        return idRecipe == that.idRecipe &&
                barcodeIngredient == that.barcodeIngredient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecipe, barcodeIngredient);
    }
}
