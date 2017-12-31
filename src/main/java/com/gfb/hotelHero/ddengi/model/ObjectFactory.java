package com.gfb.hotelHero.ddengi.model;

//import com.gfb.hotelHero.ddengi.GetRecordListParams;

public class ObjectFactory {

    /**
     * Create an instance of {@link Item }
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link GetRecordListRequest }
     */
    public GetRecordListRequest createGetRecordListRequest() {
        return new GetRecordListRequest();
    }

    /**
     * Create an instance of {@link GetRecordListResponse }
     */
    public GetRecordListResponse createGetRecordListResponse() {
        return new GetRecordListResponse();
    }

    /**
     * Create an instance of {@link GetRecordListReturnItem }
     */
    public GetRecordListReturnItem createGetRecordListReturnItem() {
        return new GetRecordListReturnItem();
    }

}
