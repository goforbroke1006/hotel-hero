package com.gfb.hotelHero.ddengi.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "getRecordList")
public class GetRecordListRequest extends BaseRequest {
    @XmlElement(name = "params")
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
}
