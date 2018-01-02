package com.gfb.hotelHero.vkontakte.domain.messages;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({
        "attachments",
        "random_id",
        "emoji",
})
public class HistoryItem {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("body")
    private String message;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("from_id")
    private Integer fromId;

    @JsonProperty("date")
    private Integer date;

    @JsonProperty("read_state")
    private Integer readState;

    @JsonProperty("out")
    private Integer out;

    @JsonProperty("chat_id")
    private Integer chatId;

    public Long getId() {
        return id;
    }

    public HistoryItem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public HistoryItem setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public HistoryItem setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getFromId() {
        return fromId;
    }

    public HistoryItem setFromId(Integer fromId) {
        this.fromId = fromId;
        return this;
    }

    public Integer getDate() {
        return date;
    }

    public HistoryItem setDate(Integer date) {
        this.date = date;
        return this;
    }

    public Integer getReadState() {
        return readState;
    }

    public HistoryItem setReadState(Integer readState) {
        this.readState = readState;
        return this;
    }

    public Integer getOut() {
        return out;
    }

    public HistoryItem setOut(Integer out) {
        this.out = out;
        return this;
    }

    public Integer getChatId() {
        return chatId;
    }

    public HistoryItem setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }
}
