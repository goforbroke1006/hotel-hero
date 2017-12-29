
package com.gfb.hotelHero.ddengi;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "text",
    "is_report",
})
@XmlRootElement(name = "CheckTextsRequest")
public class CheckTextsRequest {

    protected List<String> text;

//    @XmlElement(name = "is_report")
    protected Boolean is_report;

    @XmlAttribute(name = "lang")
    protected String lang;
    @XmlAttribute(name = "options")
    protected Integer options;
    @XmlAttribute(name = "format")
    protected String format;

    public List<String> getText() {
        if (text == null) {
            text = new ArrayList<String>();
        }
        return this.text;
    }

    public Boolean getIs_report() {
        return is_report;
    }

    public void setIs_report(Boolean is_report) {
        this.is_report = is_report;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String value) {
        this.lang = value;
    }

    public int getOptions() {
        if (options == null) {
            return  0;
        } else {
            return options;
        }
    }

    public void setOptions(Integer value) {
        this.options = value;
    }

    public String getFormat() {
        if (format == null) {
            return "";
        } else {
            return format;
        }
    }

    public void setFormat(String value) {
        this.format = value;
    }

}
