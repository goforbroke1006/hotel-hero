package com.gfb.hotelHero.ddengi;

import com.gfb.hotelHero.ddengi.model.GetRecordListRequest;
import com.gfb.hotelHero.ddengi.model.GetRecordListResponse;
import com.gfb.hotelHero.ddengi.model.GetRecordListReturnItem;
import com.gfb.hotelHero.ddengi.model.Item;
import com.sun.xml.ws.binding.BindingImpl;
import com.sun.xml.ws.client.WSServiceDelegate;
import com.sun.xml.ws.client.dispatch.JAXBDispatch;
import com.sun.xml.ws.client.dispatch.SOAPMessageDispatch;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DrebeDengiClient {

    private final QName qName = new QName("urn:ddengi", "ddengiService");
    private DdengiService service = new DdengiService(
            new URL("http://www.drebedengi.ru/soap/?wsdl"),
            qName);

    public DrebeDengiClient() throws MalformedURLException {
    }

    /*private static URL getWSDLURL(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return url;
    }*/

    public GetRecordListResponse getRecordList(GetRecordListRequest request) throws JAXBException, MalformedURLException {
//        new SOAPMessageDispatch(qName, Service.Mode.MESSAGE, null, null);
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

        request.setCredentials("demo_api","demo@example.com","demo");

        DdengiService service = new DdengiService(new URL("http://www.drebedengi.ru/soap/?wsdl"));

        /*JAXBContext context = JAXBContext.newInstance("com.gfb.hotelHero.ddengi.model");*/ /*JAXBContext.newInstance(
                ArrayList.class,
                Item.class,
                GetRecordListRequest.class,
                GetRecordListResponse.class,
                GetRecordListReturnItem.class
        )*/
        ;

        JAXBContext context = JAXBContext.newInstance(
                Item.class,
                GetRecordListRequest.class,
                GetRecordListResponse.class,
                GetRecordListReturnItem.class
        );

//        JAXBContext context = JAXBContext.newInstance("com.gfb.hotelHero.ddengi.model");

        Dispatch<Object> dispatch = service.createDispatch(new QName("urn:ddengi", "SoapPort"), context, Service.Mode.PAYLOAD);
        dispatch.getRequestContext().put(Dispatch.ENDPOINT_ADDRESS_PROPERTY, "http://www.drebedengi.ru/soap/?wsdl");
        dispatch.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, true);

//        Marshaller m = context.createMarshaller();
//        StringWriter sw = new StringWriter();
//        StreamResult sr = new StreamResult(sw);
//        m.marshal(request, sr);
//        Object o = dispatch.invoke(new StreamSource(new StringReader(sw.toString())));

        Object o = dispatch.invoke(request);
        return (GetRecordListResponse) o;

//        SoapPortType soapPort = service.getSoapPort();
//        Object res = soapPort.getRecordList("demo_api", "demo@example.com", "demo",
//                params, new Integer[]{});
//        return (GetRecordListResponse) res;
    }

}
