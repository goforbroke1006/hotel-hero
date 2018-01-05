package com.gfb.hotelHero.domain;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "receiving_point")
public class ReceivingPoint implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum Types {ORGANIZATION, PERSON}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    @NotNull
    private String title;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "place_address_id", nullable = false)
    private Address placeAddress;

    @Column(name = "place_phone")
    @Length(min = 0, max = 10)
    private String placePhone;

    @Column
    private Types type;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_document_id", nullable = false)
    private IdentityDocument identityDocument;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "person_address_id", nullable = false)
    private Address personAddress;

    @Column(name = "person_phone")
    @Length(min = 0, max = 10)
    private String personPhone;

    @Column(name = "organization_name")
    @Length(min = 0, max = 24)
    private String organizationName;

    @Column(name = "actual_address")
    private String actualAddress;

    @Column(name = "tin")
    @Length(min = 0, max = 12)
    private String tin;

    public Long getId() {
        return id;
    }

    public ReceivingPoint setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ReceivingPoint setTitle(String title) {
        this.title = title;
        return this;
    }

    public Address getPlaceAddress() {
        return placeAddress;
    }

    public ReceivingPoint setPlaceAddress(Address placeAddress) {
        this.placeAddress = placeAddress;
        return this;
    }

    public String getPlacePhone() {
        return placePhone;
    }

    public ReceivingPoint setPlacePhone(String placePhone) {
        this.placePhone = placePhone;
        return this;
    }

    public Types getType() {
        return type;
    }

    public ReceivingPoint setType(Types type) {
        this.type = type;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ReceivingPoint setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ReceivingPoint setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public ReceivingPoint setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public IdentityDocument getIdentityDocument() {
        return identityDocument;
    }

    public ReceivingPoint setIdentityDocument(IdentityDocument identityDocument) {
        this.identityDocument = identityDocument;
        return this;
    }

    public Address getPersonAddress() {
        return personAddress;
    }

    public ReceivingPoint setPersonAddress(Address personAddress) {
        this.personAddress = personAddress;
        return this;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public ReceivingPoint setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
        return this;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public ReceivingPoint setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public String getActualAddress() {
        return actualAddress;
    }

    public ReceivingPoint setActualAddress(String actualAddress) {
        this.actualAddress = actualAddress;
        return this;
    }

    public String getTin() {
        return tin;
    }

    public ReceivingPoint setTin(String tin) {
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
