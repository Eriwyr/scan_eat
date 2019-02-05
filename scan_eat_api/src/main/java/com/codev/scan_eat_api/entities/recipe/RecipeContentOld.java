package com.codev.scan_eat_api.entities.recipe;

import com.codev.scan_eat_api.entities.Ingredient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "recipe_ingredient")
public class RecipeContentOld implements Serializable {

    @EmbeddedId
    private RecipeContentIdentityOld recipeContentIdentityOld;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_recipe", insertable=false, updatable=false)
    @JsonIgnoreProperties("casting")
    private Recipe recipe;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="barcode_ingredient",  insertable=false, updatable=false)
    @JsonIgnoreProperties("casting")
    private Ingredient ingredient$;



    public RecipeContentOld() {
    }

    public RecipeContentIdentityOld getRecipeContentIdentityOld() {
        return recipeContentIdentityOld;
    }

    public void setRecipeContentIdentityOld(RecipeContentIdentityOld recipeContentIdentityOld) {
        this.recipeContentIdentityOld = recipeContentIdentityOld;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient$() {
        return ingredient$;
    }

    public void setIngredient$(Ingredient ingredient$) {
        this.ingredient$ = ingredient$;
    }
}
