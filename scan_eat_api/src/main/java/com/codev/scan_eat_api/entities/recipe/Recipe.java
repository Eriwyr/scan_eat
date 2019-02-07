package com.codev.scan_eat_api.entities.recipe;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "owner")
    private String owner;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "serving_modifier")
    private float servingModifier;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_recipe")
    private List<RecipeContent> ingredients;

    @Transient
    private Map<String,String> nutritionalInfo;

    @Transient
    private Serving serving;

    public Recipe() {
    }

    @PostLoad
    public void initRecipe() {
        this.serving = new Serving(this, 4);
        this.nutritionalInfo = new Serving(this, 4).getNutritionalInfo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getServingModifier() {
        return servingModifier;
    }

    public void setServingModifier(float servingModifier) {
        this.servingModifier = servingModifier;
    }

    public List<RecipeContent> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeContent> ingredients) {
        this.ingredients = ingredients;
    }

    public Serving getServing() {
        return serving;
    }

    public void setServing(Serving serving) {
        this.serving = serving;
    }

    public Map<String, String> getNutritionalInfo() {
        return nutritionalInfo;
    }

    public void setNutritionalInfo(Map<String, String> nutritionalInfo) {
        this.nutritionalInfo = nutritionalInfo;
    }
}
