package com.gfb.hotelHero.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "identity_document")
public class IdentityDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum Types {PASSPORT}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private Types type = Types.PASSPORT;

    @Column(name = "series")
    private String series;

    @Column(name = "identifier")
    private String identifier;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_issue_date")
    private Date dateOfIssueDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "validity_till_date")
    private Date validityTillDate;

    public Long getId() {
        return id;
    }

    public IdentityDocument setId(Long id) {
        this.id = id;
        return this;
    }

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
