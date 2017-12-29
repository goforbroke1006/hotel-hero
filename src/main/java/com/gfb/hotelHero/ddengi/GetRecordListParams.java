package com.gfb.hotelHero.ddengi;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

//@XmlRootElement(name = "params", namespace = "urn:ddengi")
//@XmlAccessorType(value = XmlAccessType.FIELD)
//@XmlType(name="anyType")
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name = "params")
//@XmlAccessorType(XmlAccessType.PROPERTY)
//@XmlType(name = "params", propOrder = {
//        "report",
//        "showDuty",
//        "period",
//        "how",
//        "what",
//        "currency",
//        "place",
//        "tag",
//})

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "text"
})
@XmlRootElement(name = "GetRecordListParams")
public class GetRecordListParams {
    protected List<String> text;

    @XmlAttribute(name = "is_report")
    protected Boolean report;

    @XmlAttribute(name = "is_show_duty")
    protected Boolean showDuty;

    @XmlAttribute(name = "r_period")
    protected Integer period;

    @XmlAttribute(name = "r_how")
    protected Integer how;

    @XmlAttribute(name = "r_what")
    protected Integer what;

    @XmlAttribute(name = "r_currency")
    protected Integer currency;

    @XmlAttribute(name = "r_is_place")
    protected Integer place;

    @XmlAttribute(name = "r_is_tag")
    protected Integer tag;

    public List<String> getText() {
        if (text == null) {
            text = new ArrayList<String>();
        }
        return this.text;
    }

    public Boolean getReport() {
        return report;
    }

    public void setReport(Boolean report) {
        this.report = report;
    }

    public Boolean getShowDuty() {
        return showDuty;
    }

    public void setShowDuty(Boolean showDuty) {
        this.showDuty = showDuty;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getHow() {
        return how;
    }

    public void setHow(Integer how) {
        this.how = how;
    }

    public Integer getWhat() {
        return what;
    }

    public void setWhat(Integer what) {
        this.what = what;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }
}
