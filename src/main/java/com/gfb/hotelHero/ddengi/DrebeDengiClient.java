package com.gfb.hotelHero.ddengi;

import com.gfb.hotelHero.ddengi.model.*;
import com.sun.xml.ws.binding.BindingImpl;
import com.sun.xml.ws.client.WSServiceDelegate;
import com.sun.xml.ws.client.dispatch.JAXBDispatch;
import com.sun.xml.ws.client.dispatch.SOAPMessageDispatch;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DrebeDengiClient {

    private final QName qName = new QName("urn:ddengi", "ddengiService");
    private DdengiService service = new DdengiService(
            new URL("http://www.drebedengi.ru/soap/?wsdl"),
            qName);

    public DrebeDengiClient() throws MalformedURLException {
    }

    public GetRecordListResponse getRecordList(GetRecordListRequest request) throws JAXBException, MalformedURLException {

        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

        request.setCredentials("demo_api", "demo@example.com", "demo");

        DdengiService service = new DdengiService(new URL("http://www.drebedengi.ru/soap/?wsdl"));

        JAXBContext jaxbContext = JAXBContext.newInstance(
                Item.class,
                GetRecordListRequest.class,
                GetRecordListRequestParams.class,
                GetRecordListResponse.class,
                GetRecordListReturnItem.class
        );

        Dispatch<Object> dispatch = service.createDispatch(new QName("urn:ddengi", "SoapPort"), jaxbContext, Service.Mode.PAYLOAD);
        dispatch.getRequestContext().put(Dispatch.ENDPOINT_ADDRESS_PROPERTY, "http://www.drebedengi.ru/soap/?wsdl");
        dispatch.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, true);

        dispatch.getBinding().getHandlerChain().add(new Handler() {
            @Override
            public boolean handleMessage(MessageContext context) {
                System.out.println(context.toString());
                return true;
            }

            @Override
            public boolean handleFault(MessageContext context) {
                return false;
            }

            @Override
            public void close(MessageContext messageContext) {

            }
        });
        /*dispatch.getBinding().setHandlerChain(Arrays.asList(
                new SOAPHandler<SOAPMessageContext>() {
                    @Override
                    public Set<QName> getHeaders() {
                        return null;
                    }

                    @Override
                    public boolean handleMessage(SOAPMessageContext context) {
                        try {
                            final SOAPMessage soapMessage = context.getMessage();
                            final SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
                            final SOAPHeader soapHeader = soapMessage.getSOAPHeader();
                            final SOAPBody soapBody = soapMessage.getSOAPBody();

                            soapEnvelope.addNamespaceDeclaration("SOAP-ENV", "http://schemas.xmlsoap.org/soap/envelope/");
                            soapEnvelope.addNamespaceDeclaration("SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
                            soapEnvelope.addNamespaceDeclaration("ns1", "urn:ddengi");
                            soapEnvelope.addNamespaceDeclaration("ns2", "http://xml.apache.org/xml-soap");
                            soapEnvelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
                            soapEnvelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");

//                            soapEnvelope.setPrefix("SOAP-ENV");
//                            soapHeader.setPrefix("SOAP-ENV");
//                            soapBody.setPrefix("SOAP-ENV");

                            soapMessage.saveChanges();
                        } catch (SOAPException e) {
//                    e.printStackTrace();
                        }
                        return true;
                    }

                    @Override
                    public boolean handleFault(SOAPMessageContext soapMessageContext) {
                        return true;
                    }

                    @Override
                    public void close(MessageContext messageContext) {

                    }
                }
        ));*/

//        Marshaller m = jaxbContext.createMarshaller();
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
