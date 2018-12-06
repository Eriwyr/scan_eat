package com.codev.scan_eat_api.enties;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Embeddable
public class RecipeContentId {

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
}
