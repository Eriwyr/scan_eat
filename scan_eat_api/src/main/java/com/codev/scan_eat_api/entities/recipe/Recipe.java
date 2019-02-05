package com.codev.scan_eat_api.entities.recipe;


import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany
    @JoinColumn(name = "id_recipe")
    private List<RecipeContent> ingredients;

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

    public List<RecipeContent> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeContent> ingredients) {
        this.ingredients = ingredients;
    }
}
