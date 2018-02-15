package com.gfb.hotelHero.ddengi;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class DdengiClient extends DdengiService {
//    private service;

    {
        GetRecordList req = new GetRecordList();
        JAXBElement jbEl = new JAXBElement(new QName("urn:ddengi", "getRecordList"), GetRecordList.class, req);
    }
}
