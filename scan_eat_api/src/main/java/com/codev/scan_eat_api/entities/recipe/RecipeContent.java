package com.codev.scan_eat_api.entities.recipe;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "recipe_ingredient")
public class RecipeContent {

    /*@JsonIgnore
    @Id
    @Column(name = "id_recipe")
    private int idRecipe;

    @Id
    @OneToOne()
    @JoinColumn(name = "barcode_ingredient")
    private Ingredient ingredient;*/

    @JsonIgnore
    @EmbeddedId
    private RecipeContentIdentity recipeContentIdentity;

    @JsonIgnore
    @Transient
    private long barcode;

    @Transient
    private String name;


    @Column(name = "quantity")
    private float quantity;

    public RecipeContent() {
    }

    @PostLoad
    public void initFields() {
        this.name = this.recipeContentIdentity.getIngredient().getName();
    }

    /*public int getIdRecipe() {
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
    }*/

    public RecipeContentIdentity getRecipeIngredientIdentity() {
        return recipeContentIdentity;
    }

    public void setRecipeIngredientIdentity(RecipeContentIdentity recipeContentIdentity) {
        this.recipeContentIdentity = recipeContentIdentity;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public long getBarcode() {
        return barcode;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }


}
