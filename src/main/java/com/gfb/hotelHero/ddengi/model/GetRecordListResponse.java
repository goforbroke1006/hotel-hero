package com.gfb.hotelHero.ddengi.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "items",
})
@XmlRootElement(name = "getRecordListResponse", namespace = "urn:ddengi")
@XmlSeeAlso({GetRecordListReturnItem.class})
public class GetRecordListResponse {
    @XmlElementWrapper(name = "getRecordListReturn")
    @XmlElement(name = "item")
    protected List<GetRecordListReturnItem> items;

    public List<GetRecordListReturnItem> getItems() {
        return items;
    }

    public void setItems(List<GetRecordListReturnItem> items) {
        this.items = items;
    }
}
