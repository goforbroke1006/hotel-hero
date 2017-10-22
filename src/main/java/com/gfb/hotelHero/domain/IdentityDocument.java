package com.gfb.hotelHero.domain;

import java.io.Serializable;
import java.util.Date;

public class IdentityDocument implements Serializable {
    public enum Types {PASSPORT}

    private Types type = Types.PASSPORT;

    private String series;
    private String identifier;

    private Date dateOfIssueDate;
    private Date validityTillDate;

    public Types getType() {
        return type;
    }

    public IdentityDocument setType(Types type) {
        this.type = type;
        return this;
    }

    public String getSeries() {
        return series;
    }

    public IdentityDocument setSeries(String series) {
        this.series = series;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public IdentityDocument setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public Date getDateOfIssueDate() {
        return dateOfIssueDate;
    }

    public IdentityDocument setDateOfIssueDate(Date dateOfIssueDate) {
        this.dateOfIssueDate = dateOfIssueDate;
        return this;
    }

    public Date getValidityTillDate() {
        return validityTillDate;
    }

    public IdentityDocument setValidityTillDate(Date validityTillDate) {
        this.validityTillDate = validityTillDate;
        return this;
    }
}
