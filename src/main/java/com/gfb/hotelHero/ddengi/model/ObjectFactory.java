package com.gfb.hotelHero.ddengi.model;

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


    /**
     * Create an instance of {@link SetRecordListRequest }
     */
    public SetRecordListRequest createSetRecordListRequest() {
        return new SetRecordListRequest();
    }

    /**
     * Create an instance of {@link Record }
     */
    public Record createRecord() {
        return new Record();
    }

}
