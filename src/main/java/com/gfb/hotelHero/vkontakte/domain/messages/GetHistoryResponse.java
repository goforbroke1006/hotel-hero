package com.gfb.hotelHero.vkontakte.domain.messages;

import com.gfb.hotelHero.vkontakte.BaseResponse;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class GetHistoryResponse extends BaseResponse {

    @JsonProperty("skipped")
    protected Integer skipped;

    @JsonProperty("items")
    protected List<HistoryItem> items;

    @JsonProperty("in_read")
    protected Integer inRead;

    @JsonProperty("out_read")
    protected Integer outRead;

    public Integer getSkipped() {
        return skipped;
    }

    public GetHistoryResponse setSkipped(Integer skipped) {
        this.skipped = skipped;
        return this;
    }

    public List<HistoryItem> getItems() {
        return items;
    }

    public GetHistoryResponse setItems(List<HistoryItem> items) {
        this.items = items;
        return this;
    }

    public Integer getInRead() {
        return inRead;
    }

    public GetHistoryResponse setInRead(Integer inRead) {
        this.inRead = inRead;
        return this;
    }

    public Integer getOutRead() {
        return outRead;
    }

    public GetHistoryResponse setOutRead(Integer outRead) {
        this.outRead = outRead;
        return this;
    }

}
