package com.gfb.hotelHero.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "receiving_side_info")
public class ReceivingSideInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum Types {ORGANIZATION, PERSON}

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ManyToOne(cascade = {CascadeType.ALL})
    private IdentityDocument identityDocument;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Address placeAddress;

    @Column(name = "phone")
    private String phone;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "actual_address")
    private String actualAddress;

    @Column(name = "tin")
    private String tin;

    public Long getId() {
        return id;
    }

    public ReceivingSideInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ReceivingSideInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ReceivingSideInfo setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public ReceivingSideInfo setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public IdentityDocument getIdentityDocument() {
        return identityDocument;
    }

    public ReceivingSideInfo setIdentityDocument(IdentityDocument identityDocument) {
        this.identityDocument = identityDocument;
        return this;
    }

    public Address getPlaceAddress() {
        return placeAddress;
    }

    public ReceivingSideInfo setPlaceAddress(Address placeAddress) {
        this.placeAddress = placeAddress;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ReceivingSideInfo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public ReceivingSideInfo setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public String getActualAddress() {
        return actualAddress;
    }

    public ReceivingSideInfo setActualAddress(String actualAddress) {
        this.actualAddress = actualAddress;
        return this;
    }

    public String getTin() {
        return tin;
    }

    public ReceivingSideInfo setTin(String tin) {
        this.tin = tin;
        return this;
    }

    @Override
    public String toString() {
        return "ReceivingSideInfo{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", actualAddress='" + actualAddress + '\'' +
                '}';
    }
}
