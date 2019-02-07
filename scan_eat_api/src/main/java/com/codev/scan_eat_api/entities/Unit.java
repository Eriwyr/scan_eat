package com.codev.scan_eat_api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "unit")
public class Unit {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @Column(name = "mapping")
    private String mapping;

    @JsonIgnore
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="base_unit",  insertable=false, updatable=false)
    private Unit baseUnit;

    @JsonIgnore
    @Column(name = "base_unit_conversion")
    private float baseUnitConversion;

    public Unit() {
    }

    public Unit(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public Unit getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(Unit baseUnit) {
        this.baseUnit = baseUnit;
    }

    public float getBaseUnitConversion() {
        return baseUnitConversion;
    }

    public void setBaseUnitConversion(float baseUnitConversion) {
        this.baseUnitConversion = baseUnitConversion;
    }
}
