package com.gfb.hotelHero.ddengi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "apiId",
        "login",
        "password",
})
public abstract class BaseRequest {
    @XmlElement(name = "apiId")
    protected String apiId;

    @XmlElement(name = "login")
    protected String login;

    @XmlElement(name = "pass")
    protected String password;

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCredentials(String apiId, String login, String password) {
        this.apiId = apiId;
        this.login = login;
        this.password = password;
    }
}
