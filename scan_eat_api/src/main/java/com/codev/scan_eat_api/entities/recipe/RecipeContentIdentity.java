package com.codev.scan_eat_api.entities.recipe;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Table(name = "recipe_ingredient")
public class RecipeContentIdentity implements Serializable {

    @Column(name = "id_recipe")
    private int idRecipe;

    @Column(name = "barcode_ingredient")
    private long barcodeIngredient;

    public RecipeContentIdentity() {
    }

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
    public String toString() {
        return "RecipeContentIdentity{" +"\n"+
                "idRecipe=" + idRecipe +"\n"+
                ", barcodeIngredient=" + barcodeIngredient +"\n"+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeContentIdentity castingId = (RecipeContentIdentity) o;
        return idRecipe == castingId.idRecipe &&
                barcodeIngredient == castingId.barcodeIngredient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecipe, barcodeIngredient);
    }
}



