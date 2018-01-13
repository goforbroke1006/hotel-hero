package com.gfb.hotelHero.ddengi.model;

import com.gfb.hotelHero.ddengi.DdengiService;

import javax.xml.bind.annotation.XmlElement;
import java.text.ParseException;
import java.util.Date;

public class Record {

    private Long serverId;
    private Long placeId;
    private Long budgetObjectId;
    private float sum;
    private Date operationDate;
    private String comment;
    private Long currencyId;
    private boolean duty;
    private Long operationType;

    @XmlElement(name = "server_id")
    public Long getServerId() {
        return serverId;
    }

    public Record setServerId(Long serverId) {
        this.serverId = serverId;
        return this;
    }

    @XmlElement(name = "place_id")
    public Long getPlaceId() {
        return placeId;
    }

    public Record setPlaceId(Long placeId) {
        this.placeId = placeId;
        return this;
    }

    @XmlElement(name = "budget_object_id")
    public Long getBudgetObjectId() {
        return budgetObjectId;
    }

    public Record setBudgetObjectId(Long budgetObjectId) {
        this.budgetObjectId = budgetObjectId;
        return this;
    }

    @XmlElement(name = "sum")
    public float getSum() {
        return sum;
    }

    public Record setSum(float sum) {
        this.sum = sum;
        return this;
    }

    @XmlElement(name = "operation_date")
    public String getOperationDateStr() {
        return DdengiService.DATE_FORMAT.format(operationDate);
    }

    public Record setOperationDateStr(String operationDate) throws ParseException {
        this.operationDate = DdengiService.DATE_FORMAT.parse(operationDate);
        return this;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public Record setOperationDate(Date operationDate) throws ParseException {
        this.operationDate = operationDate;
        return this;
    }

    @XmlElement(name = "comment")
    public String getComment() {
        return comment;
    }

    public Record setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @XmlElement(name = "currency_id")
    public Long getCurrencyId() {
        return currencyId;
    }

    public Record setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
        return this;
    }

    @XmlElement(name = "is_duty")
    public boolean isDuty() {
        return duty;
    }

    public Record setDuty(boolean duty) {
        this.duty = duty;
        return this;
    }

    @XmlElement(name = "operation_type")
    public Long getOperationType() {
        return operationType;
    }

    public Record setOperationType(Long operationType) {
        this.operationType = operationType;
        return this;
    }
}
