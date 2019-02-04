package com.codev.scan_eat_api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @Column(name = "barcode")
    private long barcode;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @Column(name = "last_refresh")
    private long lastRefresh;

    public Ingredient() {
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLastRefresh() {
        return lastRefresh;
    }

    public void setLastRefresh(long lastRefresh) {
        this.lastRefresh = lastRefresh;
    }


}
