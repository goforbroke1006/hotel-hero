package com.gfb.hotelHero.vkontakte;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class BaseResponse {

    @JsonProperty("count")
    protected Integer count;

//    @JsonProperty("items")
//    protected List<Object> items;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

//    public List<Object> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Object> items) {
//        this.items = items;
//    }

}
