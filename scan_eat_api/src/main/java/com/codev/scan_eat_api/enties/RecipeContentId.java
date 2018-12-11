package com.codev.scan_eat_api.enties;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeContentId implements Serializable {

    @Column(name = "id_recipe")
    private int idRecipe;

    @Column(name = "id_ingredient")
    private Ingredient ingredient;

    public RecipeContentId() {
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
        RecipeContentId that = (RecipeContentId) o;
        return getIdRecipe() == that.getIdRecipe() &&
                Objects.equals(getIngredient(), that.getIngredient());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdRecipe(), getIngredient());
    }
}
