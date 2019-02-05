package com.codev.scan_eat_api.entities.recipe;


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

    @EmbeddedId
    private RecipeContentIdentity recipeContentIdentity;

    @Transient
    private long barcode;

    @Column(name = "quantity")
    private float quantity;

    public RecipeContent() {
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

    /*@PostLoad
    public void initBarcode() {
        this.barcode = this.ingredient.getBarcode();
    }*/

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }


}
