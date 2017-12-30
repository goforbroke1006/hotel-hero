package com.gfb.hotelHero;

import com.gfb.hotelHero.ddengi.DdengiService;
import com.gfb.hotelHero.ddengi.GetRecordListParams;
import com.gfb.hotelHero.ddengi.CheckTextsRequest;
import com.gfb.hotelHero.ddengi.Item;
//import com.gfb.hotelHero.ddengi.GetRecordList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws Exception {

        QName serviceName = new QName("urn:ddengi", "ddengiService");
        QName portName = new QName("urn:ddengi", "ddengiServicePort");

        String endpointUrl = "http://www.drebedengi.ru/soap/dd.wsdl";

        Service service = Service.create(serviceName);
        service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, endpointUrl);

        Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);

        MessageFactory mf = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);

        SOAPMessage request = mf.createMessage();
        SOAPPart part = request.getSOAPPart();

        SOAPEnvelope env = part.getEnvelope();
        SOAPHeader header = env.getHeader();
        SOAPBody body = env.getBody();

        SOAPElement operation = body.addChildElement("getRecordList", "ns1", "urn:ddengi");
        operation.addChildElement("apiId").addTextNode("demo_api");
        operation.addChildElement("login").addTextNode("demo@example.com");
        operation.addChildElement("pass").addTextNode("demo");

        SOAPElement params = operation.addChildElement("params");

        SOAPElement i1 = params.addChildElement("item");
        i1.addChildElement("key").addTextNode("is_report");
        i1.addChildElement("value").addTextNode("false");

        SOAPElement i2 = params.addChildElement("item");
        i2.addChildElement("key").addTextNode("is_show_duty");
        i2.addChildElement("value").addTextNode("true");

        SOAPElement i3 = params.addChildElement("item");
        i3.addChildElement("key").addTextNode("r_period");
        i3.addChildElement("value").addTextNode("8");

        SOAPElement i4 = params.addChildElement("item");
        i4.addChildElement("key").addTextNode("r_how");
        i4.addChildElement("value").addTextNode("1");

        SOAPElement i5 = params.addChildElement("item");
        i5.addChildElement("key").addTextNode("r_what");
        i5.addChildElement("value").addTextNode("6");

        SOAPElement i6 = params.addChildElement("item");
        i6.addChildElement("key").addTextNode("r_currency");
        i6.addChildElement("value").addTextNode("0");

        SOAPElement i7 = params.addChildElement("item");
        i7.addChildElement("key").addTextNode("r_is_place");
        i7.addChildElement("value").addTextNode("0");

        SOAPElement i8 = params.addChildElement("item");
        i8.addChildElement("key").addTextNode("r_is_tag");
        i8.addChildElement("value").addTextNode("0");

        request.saveChanges();

        SOAPMessage response = dispatch.invoke(request);
        System.out.println(response.getSOAPBody().toString());

//        Marshaller m = context.createMarshaller();
//        m.marshal(req, System.out);
//        return;


//        JAXBElement jbEl = new JAXBElement(new QName("urn:ddengi","getRecordList"), GetRecordList.class, req);
//        ddengiService.get

//        Integer[] ids = {1, 2, 3};
//        Object res = ddengiService.getSoapPort().getRecordList(
//                "demo_api", "demo@example.com", "demo",
//                req, ids);
//        System.out.println(res.toString());
//        return;
//        new WebServer(8080).start();
    }
}
