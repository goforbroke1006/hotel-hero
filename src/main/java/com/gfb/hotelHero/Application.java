package com.gfb.hotelHero;

//import com.gfb.hotelHero.ddengi.GetRecordList;

import com.gfb.hotelHero.ddengi.GetRecordListParams;
import com.gfb.hotelHero.ddengi.model.GetRecordListResponse;
import com.sun.xml.messaging.saaj.util.ByteInputStream;
import com.sun.xml.messaging.saaj.util.JAXMStreamSource;
import org.w3c.dom.Document;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.soap.SOAPBinding;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class Application {
    //    @WebServiceRef(wsdlLocation = "http://www.drebedengi.ru/soap/?wsdl")
//    static DdengiService service;

    /*private void testDdengi() throws MalformedURLException {
        DdengiService service = new DdengiService(new URL("http://www.drebedengi.ru/soap/?wsdl"));

        SoapPortType port = service.getSoapPort();

        GetRecordListParams params = new GetRecordListParams(false, true, 9, 8, 0, 0, 0, 0);

        Object response = port.getRecordList("demo_api", "demo@example.com", "demo",
                params, new Integer[]{});
        System.out.println(response);
    }*/

    public static void main(String[] args) throws Exception {

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

        SOAPElement operation = body.addChildElement("getRecordList", "ns1", "urn:ddengi");
        operation.addChildElement("apiId").addTextNode("demo_api");
        operation.addChildElement("login").addTextNode("demo@example.com");
        operation.addChildElement("pass").addTextNode("demo");

        SOAPElement params = operation.addChildElement("params")
                .addAttribute(new QName("xsi:type"), "ns2:Map");

        SOAPElement i1 = params.addChildElement("item");
        i1.addChildElement("key").addTextNode("is_report");
        i1.addChildElement("value").addTextNode("false")
                .addAttribute(new QName("xsi:type"), "xsd:boolean");

        SOAPElement i2 = params.addChildElement("item");
        i2.addChildElement("key").addTextNode("is_show_duty");
        i2.addChildElement("value").addTextNode("true")
                .addAttribute(new QName("xsi:type"), "xsd:boolean");

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
