package com.codev.scan_eat_api.entities.ingredient;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Table(name = "ingredient_additive")
public class IngredientAdditiveIdentity implements Serializable {

    @Column(name = "barcode_ingredient")
    private long barcodeIngredient;

    @Column(name = "id_additive")
    private String idAdditive;

    public IngredientAdditiveIdentity() {
    }

    public IngredientAdditiveIdentity(long barcodeIngredient, String idAdditive) {
        this.barcodeIngredient = barcodeIngredient;
        this.idAdditive = idAdditive;
    }

    public long getBarcodeIngredient() {
        return barcodeIngredient;
    }

    public void setBarcodeIngredient(long barcodeIngredient) {
        this.barcodeIngredient = barcodeIngredient;
    }

    public String getIdAdditive() {
        return idAdditive;
    }

    public void setIdAdditive(String idAdditive) {
        this.idAdditive = idAdditive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientAdditiveIdentity that = (IngredientAdditiveIdentity) o;
        return barcodeIngredient == that.barcodeIngredient &&
                Objects.equals(idAdditive, that.idAdditive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcodeIngredient, idAdditive);
    }
}
