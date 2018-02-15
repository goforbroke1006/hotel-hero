package com.gfb.hotelHero.ddengi;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRecordList", propOrder = {"isReport", "isShowDuty", "period"})
@XmlRootElement(name = "params")
public class GetRecordList {
    @XmlElement(name = "is_report")
    protected Boolean isReport = false;
    @XmlElement(name = "is_show_duty")
    protected Boolean isShowDuty = true;
    @XmlElement(name = "r_period")
    protected Integer period = 100;


    public boolean isReport() {
        return isReport;
    }

    public void setReport(boolean report) {
        isReport = report;
    }


    public boolean isShowDuty() {
        return isShowDuty;
    }

    public void setShowDuty(boolean showDuty) {
        isShowDuty = showDuty;
    }


    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
