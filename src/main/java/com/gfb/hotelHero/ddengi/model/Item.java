package com.gfb.hotelHero.ddengi.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "key",
        "value",
})
@XmlRootElement(name = "item")
public class Item {
    @XmlElement(name = "key")
    protected String key;

    @XmlElement(name = "value")
    protected Object value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
