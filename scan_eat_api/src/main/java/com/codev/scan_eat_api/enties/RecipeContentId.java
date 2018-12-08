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
    private int idIngredient;

    public RecipeContentId() {
    }

    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeContentId that = (RecipeContentId) o;
        return idRecipe == that.idRecipe &&
                idIngredient == that.idIngredient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecipe, idIngredient);
    }
}
