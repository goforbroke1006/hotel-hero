package com.gfb.hotelHero.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payment_log")
public class PaymentLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "vkontakte_message_id", unique = true)
    private Long vkontakteMessageId;

    @Column(name = "message_text")
    private String messageText;

    @Column(name = "ddengiServerId", nullable = true)
    private int ddengiServerId;

    public Long getVkontakteMessageId() {
        return vkontakteMessageId;
    }

    public PaymentLog setVkontakteMessageId(Long vkontakteMessageId) {
        this.vkontakteMessageId = vkontakteMessageId;
        return this;
    }

    public String getMessageText() {
        return messageText;
    }

    public PaymentLog setMessageText(String messageText) {
        this.messageText = messageText;
        return this;
    }

    public int getDdengiServerId() {
        return ddengiServerId;
    }

    public PaymentLog setDdengiServerId(int ddengiServerId) {
        this.ddengiServerId = ddengiServerId;
        return this;
    }

    @Override
    public String toString() {
        return "PaymentLog{" +
                "vkontakteMessageId=" + vkontakteMessageId +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
