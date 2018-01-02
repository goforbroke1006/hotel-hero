package com.gfb.hotelHero.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "app_settings")
public class AppSettings implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "date_format")
    private String dateFormat;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "payment_regexp_list")
    private String paymentRegexpList;

    public String getDateFormat() {
        return dateFormat;
    }

    public AppSettings setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public Long getId() {
        return id;
    }

    public AppSettings setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public AppSettings setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public String getPaymentRegexpList() {
        return paymentRegexpList;
    }

    public AppSettings setPaymentRegexpList(String paymentRegexpList) {
        this.paymentRegexpList = paymentRegexpList;
        return this;
    }
}
