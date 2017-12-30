package com.gfb.hotelHero.ddengi;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "report",
        "showDuty",
        "period",
        "how",
        "what",
        "currency",
        "place",
        "tag",
})
@XmlRootElement(name = "GetRecordListParams")
public class GetRecordListParams {
    @XmlElement(name = "is_report")
    protected Boolean report;

    @XmlElement(name = "is_show_duty")
    protected Boolean showDuty;

    @XmlElement(name = "r_period")
    protected Integer period;

    @XmlElement(name = "r_how")
    protected Integer how;

    @XmlElement(name = "r_what")
    protected Integer what;

    @XmlElement(name = "r_currency")
    protected Integer currency;

    @XmlElement(name = "r_is_place")
    protected Integer place;

    @XmlElement(name = "r_is_tag")
    protected Integer tag;

    public GetRecordListParams() {
    }

    public GetRecordListParams(Boolean report, Boolean showDuty, Integer period, Integer how, Integer what, Integer currency, Integer place, Integer tag) {
        this.report = report;
        this.showDuty = showDuty;
        this.period = period;
        this.how = how;
        this.what = what;
        this.currency = currency;
        this.place = place;
        this.tag = tag;
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
