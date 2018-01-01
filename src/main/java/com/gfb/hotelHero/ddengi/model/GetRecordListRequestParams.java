package com.gfb.hotelHero.ddengi.model;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlAccessorType(value = XmlAccessType.FIELD)
public class GetRecordListRequestParams {

    @XmlAttribute(name = "type", namespace = "http://www.w3.org/2001/XMLSchema-instance")
    protected String type = "ns2:Map";

    @XmlElement(name = "item")
    protected List<Item> items = new ArrayList<>();

    public String getType() {
        return type;
    }

    public GetRecordListRequestParams setType(String type) {
        this.type = type;
        return this;
    }

    public List<Item> getItems() {
        return items;
    }

    public GetRecordListRequestParams setItems(List<Item> items) {
        this.items = items;
        return this;
    }

    public GetRecordListRequestParams addItem(Item param) {
        this.items.add(param);
        return this;
    }

}
