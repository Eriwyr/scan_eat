package com.codev.scan_eat_api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Additive {

    @Id
    @Column(name = "id")
    private String id;

    @JsonIgnore
    @Column(name = "name")
    private String name;

    public Additive() {
    }

    public Additive(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
