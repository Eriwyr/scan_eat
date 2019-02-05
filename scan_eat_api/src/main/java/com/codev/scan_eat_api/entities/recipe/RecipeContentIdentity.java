package com.codev.scan_eat_api.entities.recipe;

import com.codev.scan_eat_api.entities.Ingredient;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeContentIdentity implements Serializable {

    @Column(name = "id_recipe")
    private int idRecipe;


    @OneToOne()
    @JoinColumn(name = "barcode_ingredient")
    private Ingredient ingredient;

    public RecipeContentIdentity() {
    }


    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeContentIdentity that = (RecipeContentIdentity) o;
        return idRecipe == that.idRecipe &&
                Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecipe, ingredient);
    }
}
