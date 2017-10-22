package com.gfb.hotelHero.domain;

import java.io.Serializable;

public class PlaceOfBirth implements Serializable {
    private String county;
    private String city;

    public String getCounty() {
        return county;
    }

    public PlaceOfBirth setCounty(String county) {
        this.county = county;
        return this;
    }

    public String getCity() {
        return city;
    }

    public PlaceOfBirth setCity(String city) {
        this.city = city;
        return this;
    }
}
