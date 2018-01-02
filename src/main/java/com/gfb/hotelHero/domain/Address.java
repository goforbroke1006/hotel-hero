package com.gfb.hotelHero.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Column(name = "country")
    private String county;

    @Column(name = "city")
    private String city;

    @Column(name = "house")
    private String house;

    @Column(name = "unit")
    private String unit;

    @Column(name = "building")
    private String building;

    @Column(name = "flat")
    private String flat;

    public String getCounty() {
        return county;
    }

    public Address setCounty(String county) {
        this.county = county;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getHouse() {
        return house;
    }

    public Address setHouse(String house) {
        this.house = house;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public Address setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public String getBuilding() {
        return building;
    }

    public Address setBuilding(String building) {
        this.building = building;
        return this;
    }

    public String getFlat() {
        return flat;
    }

    public Address setFlat(String flat) {
        this.flat = flat;
        return this;
    }
}
