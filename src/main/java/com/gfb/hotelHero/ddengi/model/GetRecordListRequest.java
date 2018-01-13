package com.gfb.hotelHero.ddengi.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "params",
})
@XmlRootElement(name = "getRecordList")
@XmlSeeAlso({GetRecordListRequestParams.class})
public class GetRecordListRequest extends BaseRequest {

    protected GetRecordListRequestParams params = new GetRecordListRequestParams();

    public GetRecordListRequestParams getParams() {
        return params;
    }

    public GetRecordListRequest setParams(GetRecordListRequestParams params) {
        this.params = params;
        return this;
    }

}
