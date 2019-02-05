package com.codev.scan_eat_api.entities.recipe;


import com.codev.scan_eat_api.entities.Ingredient;
import com.codev.scan_eat_api.entities.Unit;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "recipe_ingredient")
public class RecipeContent {

    @JsonIgnore
    @EmbeddedId
    private RecipeContentIdentity recipeContentIdentity;

    @ManyToOne()
    @JoinColumn(name = "barcode_ingredient", insertable=false, updatable=false)
    private Ingredient ingredient;

    @Transient
    private Long barcode;

    @Transient
    private String name;

    @Column(name = "quantity")
    private float quantity;

    /*@JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_unit",  insertable=false, updatable=false)
    private Unit unit;

    @Transient
    private Integer idUnit;

    @Column(name = "id_unit")
    private String unitName;*/

    public RecipeContent() {
    }

    public RecipeContent(int idRecipe, long barcodeIngredient, float quantity, int idUnit) {
        this.recipeContentIdentity = new RecipeContentIdentity(idRecipe, barcodeIngredient);
        this.quantity = quantity;
        //this.idUnit = idUnit;
    }

    @PostLoad
    public void initFields() {
        this.name = this.ingredient.getName();
        //this.unitName = this.unit.getName();
        //this.idUnit = this.unit.getId();
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
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

    /*public Unit getUnit() {
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
    }*/

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    /*public Integer getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(Integer idUnit) {
        this.idUnit = idUnit;
    }*/
}
