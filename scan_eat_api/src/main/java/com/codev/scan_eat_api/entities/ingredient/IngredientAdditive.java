package com.codev.scan_eat_api.entities.ingredient;

import com.codev.scan_eat_api.entities.Additive;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ingredient_additive")
public class IngredientAdditive implements Serializable {

    @JsonIgnore
    @EmbeddedId
    private IngredientAdditiveIdentity ingredientAdditiveIdentity;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "barcode_ingredient", insertable=false, updatable=false)
    private Ingredient ingredient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_additive", insertable=false, updatable=false)
    private Additive additive;

    public IngredientAdditive(long barcode_ingredient, String id_additive) {
        setIngredientAdditiveIdentity(new IngredientAdditiveIdentity(barcode_ingredient, id_additive));
    }

    public IngredientAdditive() {
    }

    public IngredientAdditiveIdentity getIngredientAdditiveIdentity() {
        return ingredientAdditiveIdentity;
    }

    public void setIngredientAdditiveIdentity(IngredientAdditiveIdentity ingredientAdditiveIdentity) {
        this.ingredientAdditiveIdentity = ingredientAdditiveIdentity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Additive getAdditive() {
        return additive;
    }

    public void setAdditive(Additive additive) {
        this.additive = additive;
    }
}
