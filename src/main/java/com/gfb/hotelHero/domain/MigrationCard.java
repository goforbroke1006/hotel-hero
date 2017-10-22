package com.gfb.hotelHero.domain;

import java.io.Serializable;

public class MigrationCard implements Serializable {
    private String series;
    private String number;

    public String getSeries() {
        return series;
    }

    public MigrationCard setSeries(String series) {
        this.series = series;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public MigrationCard setNumber(String number) {
        this.number = number;
        return this;
    }
}
