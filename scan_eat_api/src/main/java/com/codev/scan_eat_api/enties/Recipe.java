package com.codev.scan_eat_api.enties;


import javax.persistence.*;

@Entity
public class Recipe {
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany
    @JoinColumn(name = "id")
    private RecipeContent recipeContent;

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
}
