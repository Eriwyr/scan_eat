package com.codev.scan_eat_api.entities.recipe;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Table(name = "recipe_ingredient")
public class RecipeContentIdentity implements Serializable {

    @Column(name = "id_recipe")
    private int film;

    @Column(name = "barcode_ingredient")
    private long actor;


    /*@ManyToOne
    @JoinColumn(name = "id_film")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "id_actor")
    private Actor actor;*/

    public RecipeContentIdentity() {
    }

    public RecipeContentIdentity(int film, long actor) {
        this.film = film;
        this.actor = actor;
    }

    public int getFilm() {
        return film;
    }

    public void setFilm(int film) {
        this.film = film;
    }

    public long getActor() {
        return actor;
    }

    public void setActor(long actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "RecipeContentIdentity{" +"\n"+
                "film=" + film +"\n"+
                ", actor=" + actor +"\n"+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeContentIdentity castingId = (RecipeContentIdentity) o;
        return film == castingId.film &&
                actor == castingId.actor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(film, actor);
    }
}



