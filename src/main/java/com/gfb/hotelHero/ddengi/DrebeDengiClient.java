package com.gfb.hotelHero.ddengi;

import com.gfb.hotelHero.ddengi.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import java.net.MalformedURLException;
import java.net.URL;

//@Service
public class DrebeDengiClient {

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

        request.setCredentials(apiId, login, password);

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

        Dispatch<Object> dispatch = service.createDispatch(
                new QName("urn:ddengi", "SoapPort"),
                jaxbContext,
                javax.xml.ws.Service.Mode.PAYLOAD);

        Object o = dispatch.invoke(request);
        return (GetRecordListResponse) o;
    }

}
