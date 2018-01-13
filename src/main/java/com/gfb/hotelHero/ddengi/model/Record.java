package com.gfb.hotelHero.ddengi.model;

import com.gfb.hotelHero.ddengi.DdengiService;
import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlElement;
import java.text.ParseException;
import java.util.Date;

public class Record {

    public static final int RUSSIAN_RUBLE_ID = 17;
    public enum OperationType {INCOME, WASTE, MOVE, CHANGE}

    // client_id
    // server_id
    // server_move_id|client_move_id
    // client_change_id
    // place_id
    // budget_object_id
    // sum
    // operation_date
    // comment
    // currency_id

    private Long clientId;
    private Long serverId;
    private Long placeId;
    private Long budgetObjectId;
    private float sum;
    private Date operationDate;

    @Length(max = 2048)
    private String comment;
    private int currencyId;
    private boolean duty;
    private OperationType operationType;

    @XmlElement(name = "client_id")
    public Long getClientId() {
        return clientId;
    }

    public Record setClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

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
    public int getCurrencyId() {
        return currencyId;
    }

    public Record setCurrencyId(int currencyId) {
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

    public OperationType getOperationType() {
        return operationType;
    }

    public Record setOperationType(OperationType operationType) {
        this.operationType = operationType;
        return this;
    }

    @XmlElement(name = "operation_type")
    public int getOperationTypeInt() throws Exception {
        switch (this.operationType) {
            case INCOME:
                return 2;
            case WASTE:
                return 3;
            case MOVE:
                return 4;
            case CHANGE:
                return 5;
        }
        throw new Exception("Incorrect operation type");
    }
}
