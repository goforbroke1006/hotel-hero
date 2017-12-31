package com.gfb.hotelHero.ddengi.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "params",
})
@XmlRootElement(name = "getRecordList")
@XmlSeeAlso({Item.class})
public class GetRecordListRequest extends BaseRequest {
    @XmlElementWrapper(name = "params")
    @XmlElement(name = "item")
    protected List<Item> params = new ArrayList<>();

    public List<Item> getParams() {
        return params;
    }

    public GetRecordListRequest setParams(List<Item> params) {
        this.params = params;
        return this;
    }

    public GetRecordListRequest addParam(Item param) {
        this.params.add(param);
        return this;
    }

//    @XmlElementWrapper(name = "params")
//    @XmlElement(name = "item")
//    protected Map<String, Object> params = new HashMap<>();
//
//    public Map<String, Object> getParams() {
//        return params;
//    }
//
//    public GetRecordListRequest setParams(Map<String, Object> params) {
//        this.params = params;
//        return this;
//    }
}
