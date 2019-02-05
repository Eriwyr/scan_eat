package com.codev.scan_eat_api.entities.recipe;


import com.codev.scan_eat_api.entities.Unit;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "recipe_ingredient")
public class RecipeContent {

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

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_unit")
    private Unit unit;

    @Transient
    private String unitName;

    public RecipeContent() {
    }

    @PostLoad
    public void initFields() {
        this.name = this.recipeContentIdentity.getIngredient().getName();
        this.unitName = this.unit.getName();
    }


    public RecipeContentIdentity getRecipeContentIdentity() {
        return recipeContentIdentity;
    }

    public void setRecipeContentIdentity(RecipeContentIdentity recipeContentIdentity) {
        this.recipeContentIdentity = recipeContentIdentity;
    }
    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public long getBarcode() {
        return barcode;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
