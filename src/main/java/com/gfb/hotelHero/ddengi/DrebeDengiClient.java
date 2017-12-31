package com.gfb.hotelHero.ddengi;

import com.gfb.hotelHero.ddengi.model.GetRecordListResponse;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

public class DrebeDengiClient {

    private final QName qName = new QName(
            "http://www.drebedengi.ru/soap/?wsdl", "ddengi");
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

    public GetRecordListResponse getRecordList(GetRecordListParams params) {
        DdengiService service = new DdengiService();
        SoapPortType soapPort = service.getSoapPort();
        Object res = soapPort.getRecordList("demo_api", "demo@example.com", "demo",
                (GetRecordListParams)params, new Integer[]{});
        return (GetRecordListResponse) res;
    }

}
