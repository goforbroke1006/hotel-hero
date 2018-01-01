package com.gfb.hotelHero;

import com.gfb.hotelHero.ddengi.model.GetRecordListRequest;
import com.gfb.hotelHero.ddengi.model.GetRecordListResponse;
import com.gfb.hotelHero.server.WebServer;
import com.gfb.hotelHero.vkontakte.VkontakteClient;
import com.gfb.hotelHero.vkontakte.domain.messages.GetHistoryRequest;
import com.gfb.hotelHero.vkontakte.domain.messages.GetHistoryResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.net.URL;

public class Application {

    public static void main(String[] args) throws Exception {
        new WebServer(8080).start();
    }

    public static void main4(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("application-context.xml");
        VkontakteClient client = (VkontakteClient) ctx.getBean("vkontakteClient");
        GetHistoryResponse history = client.getMessagesPort().getHistory(new GetHistoryRequest(
                2314852,49, GetHistoryRequest.PeerTypes.GROUP_CONVERSATION));

        return;
    }

    public static void main2(String[] args) throws Exception {

//        new Application().testDdengi();


        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");


        SOAPMessage request = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createMessage();

        MimeHeaders mimeHeaders = request.getMimeHeaders();
//        mimeHeaders.addHeader("Content-Type", "application/xop+xml");
        mimeHeaders.addHeader("Content-Type", "application/xml");

        SOAPPart part = request.getSOAPPart();
        part.removeAllMimeHeaders();

        SOAPEnvelope env = part.getEnvelope();
        env.addNamespaceDeclaration("SOAP-ENV", "http://schemas.xmlsoap.org/soap/envelope/");
        env.addNamespaceDeclaration("ns1", "urn:ddengi");
        env.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
        env.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        env.addNamespaceDeclaration("ns2", "http://xml.apache.org/xml-soap");
        env.addNamespaceDeclaration("SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");

        SOAPHeader header = env.getHeader();
        SOAPBody body = env.getBody();

        JAXBContext jaxbContext = JAXBContext.newInstance(GetRecordListRequest.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

//        GetRecordListRequest request1 = new GetRecordListRequest();
//        request1.setCredentials("demo_api", "demo@example.com", "demo");
//        request1
//                .addParam(new Item("is_report", false))
//                .addParam(new Item("is_show_duty", true))
//                .addParam(new Item("r_period", 8))
//                .addParam(new Item("r_how", 1))
//                .addParam(new Item("r_what", 6))
//                .addParam(new Item("r_currency", 0))
//                .addParam(new Item("r_is_place", 0))
//                .addParam(new Item("r_is_tag", 0))
//        ;
//        // output pretty printed
//        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        StringWriter sw1 = new StringWriter();
//        jaxbMarshaller.marshal(request1, sw1);
//        body.setValue(sw1.toString());

//        SOAPElement operation = body.addChildElement("getRecordList", "ns1", "urn:ddengi");
//        operation.addChildElement("apiId").addTextNode("demo_api");
//        operation.addChildElement("login").addTextNode("demo@example.com");
//        operation.addChildElement("pass").addTextNode("demo");
//
//        SOAPElement params = operation.addChildElement("params")
//                .addAttribute(new QName("xsi:type"), "ns2:Map");
//
//        SOAPElement i1 = params.addChildElement("item");
//        i1.addChildElement("key").addTextNode("is_report");
//        i1.addChildElement("value").addTextNode("false")
//                .addAttribute(new QName("xsi:type"), "xsd:boolean");
//
//        SOAPElement i2 = params.addChildElement("item");
//        i2.addChildElement("key").addTextNode("is_show_duty");
//        i2.addChildElement("value").addTextNode("true")
//                .addAttribute(new QName("xsi:type"), "xsd:boolean");
//
//        SOAPElement i3 = params.addChildElement("item");
//        i3.addChildElement("key").addTextNode("r_period");
//        i3.addChildElement("value").addTextNode("8");
//
//        SOAPElement i4 = params.addChildElement("item");
//        i4.addChildElement("key").addTextNode("r_how");
//        i4.addChildElement("value").addTextNode("1");
//
//        SOAPElement i5 = params.addChildElement("item");
//        i5.addChildElement("key").addTextNode("r_what");
//        i5.addChildElement("value").addTextNode("6");
//
//        SOAPElement i6 = params.addChildElement("item");
//        i6.addChildElement("key").addTextNode("r_currency");
//        i6.addChildElement("value").addTextNode("0");
//
//        SOAPElement i7 = params.addChildElement("item");
//        i7.addChildElement("key").addTextNode("r_is_place");
//        i7.addChildElement("value").addTextNode("0");
//
//        SOAPElement i8 = params.addChildElement("item");
//        i8.addChildElement("key").addTextNode("r_is_tag");
//        i8.addChildElement("value").addTextNode("0");

//        request.getMimeHeaders().addHeader("Content-Type", "text/xml");
//        request.getSOAPHeader().addHeaderElement() addHeader("Content-Type", "text/xml");
        request.saveChanges();


//        URL url = new URL("http://www.drebedengi.ru/soap/?wsdl");

        SOAPConnectionFactory scf = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = scf.createConnection();
        URL url = new URL("http://www.drebedengi.ru/soap/?wsdl");

        DOMSource rs = (DOMSource) request.getSOAPPart().getContent();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        transformer.transform(rs, sr);
        System.out.println(sw.toString());
//        System.out.println(rs);
//
        SOAPMessage reply = soapConnection.call(request, url);

//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        reply.writeTo(out);
//        String strMsg = new String(out.toByteArray());
//        System.out.println(strMsg);

        JAXBContext jc = JAXBContext.newInstance(GetRecordListResponse.class);
        Unmarshaller um = jc.createUnmarshaller();
//        GetRecordListResponse output = (GetRecordListResponse) um.unmarshal(reply.getSOAPBody().extractContentAsDocument());

        DOMSource source = new DOMSource(reply.getSOAPBody().getFirstChild());
        GetRecordListResponse output = JAXB.unmarshal(source, GetRecordListResponse.class);

        return;

//        SOAPMessage response = dispatch.invoke(request);
//        System.out.println(response.getSOAPBody().toString());

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
