package com.gfb.hotelHero;

import com.gfb.hotelHero.ddengi.DdengiService;
//import com.gfb.hotelHero.ddengi.GetRecordList;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.net.URL;

public class Application {
    public static void main(String[] args) throws Exception {

        DdengiService ddengiService = new DdengiService(new URL("http://www.drebedengi.ru/soap/dd.wsdl"),
                new QName("urn:ddengi", "ddengiService"));

//        String[] params = {};
        int[] ids = {};
//        Object[] objs = {};

//        Map<String, Object> params = new HashMap<>();
//        params.put("test", true);

//        GetRecordList req = new GetRecordList();
//        JAXBElement jbEl = new JAXBElement(new QName("urn:ddengi","getRecordList"), GetRecordList.class, req);
//        ddengiService.get

//        Object res = ddengiService.getSoapPort().getRecordList("demo_api", "demo@example.com", "demo", req, ids);

        return;
//        new WebServer(8080).start();
    }
}
