package com.gfb.hotelHero.ddengi;

import com.gfb.hotelHero.ddengi.model.*;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.Dispatch;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class DrebeDengiClient {

    private static final Logger LOGGER = Logger.getLogger(DrebeDengiClient.class);

    private String apiId;
    private String login;
    private String password;

    private DdengiService service;

    public DrebeDengiClient(String wsdlLocation, String apiId, String login, String password) throws MalformedURLException {
        this.apiId = apiId;
        this.login = login;
        this.password = password;

        service = new DdengiService(new URL(wsdlLocation));
    }

    public GetRecordListResponse getRecordList(GetRecordListRequest request) {

//        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

        /*request.setCredentials(apiId, login, password);

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(
                    Item.class,
                    GetRecordListRequest.class,
                    GetRecordListRequestParams.class,
                    GetRecordListResponse.class,
                    GetRecordListReturnItem.class
            );
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }

        StringWriter writer = new StringWriter();
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(request, writer);
            LOGGER.trace("\n" + writer.toString() + "\n");
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
        }

        Dispatch<Object> dispatch = service.createDispatch(
                new QName("urn:ddengi", "SoapPort"),
                jaxbContext,
                javax.xml.ws.Service.Mode.PAYLOAD);

        Object o = dispatch.invoke(request);
        return (GetRecordListResponse) o;*/

        return (GetRecordListResponse) execute(
                request,
                new Class[]{
                        Item.class,
                        GetRecordListRequest.class,
                        GetRecordListRequestParams.class,
                        GetRecordListResponse.class,
                        GetRecordListReturnItem.class
                }
        );
    }

    public SetRecordListResponse setRecordList(SetRecordListRequest request) {
        Object tmp = execute(
                request,
                new Class[]{
                        Record.class,
                        SetRecordListRequest.class
                }
        );
        return (SetRecordListResponse) tmp;
    }

    public SetRecordListResponse addRecordList(Record record) {
        return setRecordList(new SetRecordListRequest().setList(Arrays.asList(record)));
        /*return setRecordList(new SetRecordListRequest().setList(
                new Record[]{record}
        ));*/
    }

    protected Object execute(BaseRequest request, Class[] domainList) {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

        request.setCredentials(apiId, login, password);

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(domainList);
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
            return null;
        }

        StringWriter writer = new StringWriter();
        try {
            jaxbContext.createMarshaller().marshal(request, writer);
            LOGGER.info(writer.toString());
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
        }

        Dispatch<Object> dispatch = service.createDispatch(
                new QName("urn:ddengi", "SoapPort"),
                jaxbContext,
                javax.xml.ws.Service.Mode.PAYLOAD);

        return dispatch.invoke(request);
    }

}
