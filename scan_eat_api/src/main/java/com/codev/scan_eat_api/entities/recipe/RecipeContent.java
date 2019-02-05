package com.codev.scan_eat_api.entities.recipe;

import com.codev.scan_eat_api.entities.Ingredient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeContent implements Serializable {

    @JsonIgnore
    @Id
    @Column(name = "id_recipe")
    private int idRecipe;

    @Id
    @OneToOne()
    @JoinColumn(name = "barcode_ingredient")
    private Ingredient ingredient;

    @Transient
    private long barcode;

    @Column(name = "quantity")
    private float quantity;

    public RecipeContent() {
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

    public long getBarcode() {
        return barcode;
    }

    @PostLoad
    public void initBarcode() {
        this.barcode = this.ingredient.getBarcode();
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }


}
