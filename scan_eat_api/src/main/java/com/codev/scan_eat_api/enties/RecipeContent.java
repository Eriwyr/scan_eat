package com.codev.scan_eat_api.enties;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeContent {

    @EmbeddedId
    private RecipeContentId recipeContentId;

    @Column(name = "quantity")
    private float quatity;

    public RecipeContent() {
    }

    public RecipeContentId getRecipeContentId() {
        return recipeContentId;
    }

    public void setRecipeContentId(RecipeContentId recipeContentId) {
        this.recipeContentId = recipeContentId;
    }

    public float getQuatity() {
        return quatity;
    }

    public void setQuatity(float quatity) {
        this.quatity = quatity;
    }
}
