package com.gfb.hotelHero.ddengi.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "key",
        "value",
})
@XmlRootElement(name = "item")
public class GetRecordListReturnItem {
    @XmlElement(name = "key")
    protected Integer key;

    @XmlElementWrapper()
    @XmlElement(name = "item", type = Item.class)
    protected List<Item> value;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public List<Item> getValue() {
        return value;
    }

    public void setValue(List<Item> value) {
        this.value = value;
    }
}
