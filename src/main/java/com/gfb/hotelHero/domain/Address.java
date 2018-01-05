package com.gfb.hotelHero.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "country")
    private String county;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    @Length(min = 0, max = 4)
    private String house;

    @Column(name = "unit")
    @Length(min = 0, max = 4)
    private String unit;

    @Column(name = "building")
    @Length(min = 0, max = 4)
    private String building;

    @Column(name = "flat")
    @Length(min = 0, max = 4)
    private String flat;

    public Long getId() {
        return id;
    }

    public Address setId(Long id) {
        this.id = id;
        return this;
    }

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

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
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
