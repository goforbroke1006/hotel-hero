@XmlSchema(
//        namespace="http://www.w3.org/2001/XMLSchema",
//        elementFormDefault= XmlNsForm.QUALIFIED
         xmlns = {
                 @XmlNs(prefix = "xsi", namespaceURI = "http://www.w3.org/2001/XMLSchema-instance"),
                 @XmlNs(prefix = "ns2", namespaceURI = "http://xml.apache.org/xml-soap"),
         }
)
package com.gfb.hotelHero.ddengi.model;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;