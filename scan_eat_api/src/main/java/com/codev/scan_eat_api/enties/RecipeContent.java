package com.codev.scan_eat_api.enties;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeContent{

    @JsonIgnore
    @EmbeddedId
    private RecipeContentId recipeContentId;

    @OneToOne
    @JoinColumn(name = "id_ingredient")
    private Ingredient Ingredient;


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
