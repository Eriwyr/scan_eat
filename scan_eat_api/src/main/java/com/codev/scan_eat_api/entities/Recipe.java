package com.codev.scan_eat_api.entities;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Recipe {
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany
    @JoinColumn(name = "id_recipe")
    private List<RecipeContent> recipeContent;

    public Recipe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RecipeContent> getRecipeContent() {
        return recipeContent;
    }

    public void setRecipeContent(List<RecipeContent> recipeContent) {
        this.recipeContent = recipeContent;
    }
}
