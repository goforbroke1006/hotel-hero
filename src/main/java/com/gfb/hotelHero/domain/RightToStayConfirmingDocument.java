package com.gfb.hotelHero.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class RightToStayConfirmingDocument implements Serializable {
    public enum Types {
        NONE,
        VISA, // виза
        RESIDENCE_PERMIT, // вид на жительство
        TMP_RESIDENCE_PERMIT // разрешение на временное проживание
    }

    private Types type = Types.VISA;

    private String series;
    private String identifier;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfIssueDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date validityTillDate;

    public Types getType() {
        return type;
    }

    public RightToStayConfirmingDocument setType(Types type) {
        this.type = type;
        return this;
    }

    public String getSeries() {
        return series;
    }

    public RightToStayConfirmingDocument setSeries(String series) {
        this.series = series;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public RightToStayConfirmingDocument setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public Date getDateOfIssueDate() {
        return dateOfIssueDate;
    }

    public RightToStayConfirmingDocument setDateOfIssueDate(Date dateOfIssueDate) {
        this.dateOfIssueDate = dateOfIssueDate;
        return this;
    }

    public Date getValidityTillDate() {
        return validityTillDate;
    }

    public RightToStayConfirmingDocument setValidityTillDate(Date validityTillDate) {
        this.validityTillDate = validityTillDate;
        return this;
    }
}
