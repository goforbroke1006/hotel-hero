package com.gfb.hotelHero;

import com.gfb.hotelHero.ddengi.DdengiService;
import com.gfb.hotelHero.ddengi.GetRecordListParams;
import com.gfb.hotelHero.ddengi.CheckTextsRequest;
//import com.gfb.hotelHero.ddengi.GetRecordList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.net.URL;

public class Application {
    public static void main(String[] args) throws Exception {


        DdengiService ddengiService = new DdengiService(
                new URL("http://www.drebedengi.ru/soap/dd.wsdl"),
                new QName("urn:ddengi", "ddengiService"));

        QName portName = new QName("urn:ddengi", "SoapPort");

//        Dispatch<SOAPMessage> dispatch = ddengiService.createDispatch(portName,
//                SOAPMessage.class, Service.Mode.MESSAGE);

//        JAXBContext context = JAXBContext.newInstance(GetRecordListParams.class);
        JAXBContext context = JAXBContext.newInstance("com.gfb.hotelHero.ddengi");
//        ddengiService.createDispatch(
//                new QName("urn:ddengi", "SoapPort"),
//                context, Service.Mode.MESSAGE);

//        JAXBContext context = JAXBContext.newInstance( "com.gfb.hotelHero.ddengi" );

        GetRecordListParams req = new GetRecordListParams();
//        CheckTextsRequest req = new CheckTextsRequest();
        req.setReport(true);

// marshal to System.out
        Marshaller m = context.createMarshaller();
        m.marshal(req, System.out);

        return;

//        String[] params = {};
//        int[] ids = {};
//        Object[] objs = {};

//        Map<String, Object> params = new HashMap<>();
//        params.put("test", true);


//        JAXBElement jbEl = new JAXBElement(new QName("urn:ddengi","getRecordList"), GetRecordList.class, req);
//        ddengiService.get

//        Object res = ddengiService.getSoapPort().getRecordList(
//                "demo_api", "demo@example.com", "demo",
//                req, ids);
//
//        return;
//        new WebServer(8080).start();
    }
}
