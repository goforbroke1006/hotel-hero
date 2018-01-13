package com.gfb.hotelHero.ddengi.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "list",
})
@XmlRootElement(name = "setRecordList")
@XmlSeeAlso({Record.class})
public class SetRecordListRequest extends BaseRequest {

    private List<Record> list;

    public List<Record> getList() {
        return list;
    }

    public SetRecordListRequest setList(List<Record> list) {
        this.list = list;
        return this;
    }
}
