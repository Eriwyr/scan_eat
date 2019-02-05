package com.codev.scan_eat_api.entities.recipe;

import com.codev.scan_eat_api.entities.Ingredient;
import com.codev.scan_eat_api.entities.Unit;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeContent implements Serializable{

    @EmbeddedId
    private RecipeContentIdentity id_casting;

    @Column(name = "quantity")
    private float quantity;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_recipe", insertable=false, updatable=false)
    private Recipe recipe;

    @JsonIgnore
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="barcode_ingredient",  insertable=false, updatable=false)
    private Ingredient ingredient;

    @Column(name = "id_unit")
    private int idUnit;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_unit", insertable=false, updatable=false)
    private Unit unit;

    /*@Column(name = "name")
    private String name;*/

    public RecipeContent() {
    }


    public RecipeContentIdentity getId_casting() {
        return id_casting;
    }

    public void setId_casting(RecipeContentIdentity id_casting) {
        this.id_casting = id_casting;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(int idUnit) {
        this.idUnit = idUnit;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /*public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }*/



    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    @Override
    public String toString() {
        return "RecipeContent{" +"\n"+
                "id_casting=" + id_casting +"\n"+
                //", actor=" + actor +"\n"+
                //", name='" + name + '\'' +
                '}';
    }

    /*public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }*/

    /*@PreRemove
    public void preRemove() {
        this.actor = null;
        this.film = null;
    }*/
}

