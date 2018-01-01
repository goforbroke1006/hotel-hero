package com.gfb.hotelHero.vkontakte.domain.messages;

import com.gfb.hotelHero.vkontakte.BaseRequest;

import java.util.HashMap;
import java.util.Map;

public class GetHistoryRequest extends BaseRequest {

    public enum HistoryOrder {SORT_ASC, SORT_DESC;}

    public enum PeerTypes {USER, GROUP_CONVERSATION, COMMUNITY;}

    private static final int MAX_COUNT = 200;

    private Integer offset = 0;
    private Integer count = 10;

    private Integer userId;

    private PeerTypes peerType = PeerTypes.USER;

    private Integer peerId;

    private Integer startMessageId = 0;

    private HistoryOrder order = HistoryOrder.SORT_DESC;

    public GetHistoryRequest(Integer userId, Integer peerId) {
        this(userId, peerId, PeerTypes.USER);
    }

    public GetHistoryRequest(Integer userId, Integer peerId, PeerTypes peerType) {
        this.userId = userId;
        this.peerType = peerType;
        this.peerId = peerId;
    }

    @Override
    public String getMethodName() {
        return "messages.getHistory";
    }

    public Map<String, Object> getContext() {
        Map<String, Object> ctx = new HashMap<>();
//        ctx.put("offset", getOffset());
//        ctx.put("count", getCount());
        ctx.put("user_id", getUserId());
        ctx.put("peer_id", getPeerIdCanonical());
//        ctx.put("start_message_id", getStartMessageId());
        ctx.put("rev", getRev());
        return ctx;
    }

    @Override
    public Class getResponseModel() {
        return GetHistoryResponse.class;
    }

    public Integer getOffset() {
        return offset;
    }

    public GetHistoryRequest setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Integer getCount() {
        if (count > MAX_COUNT)
            count = MAX_COUNT;
        return count;
    }

    public GetHistoryRequest setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public GetHistoryRequest setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public PeerTypes getPeerType() {
        return peerType;
    }

    public GetHistoryRequest setPeerType(PeerTypes peerType) {
        this.peerType = peerType;
        return this;
    }

    public Integer getPeerId() {
        return peerId;
    }

    public GetHistoryRequest setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public Integer getStartMessageId() {
        return startMessageId;
    }

    public GetHistoryRequest setStartMessageId(Integer startMessageId) {
        this.startMessageId = startMessageId;
        return this;
    }

    public HistoryOrder getOrder() {
        return order;
    }

    public GetHistoryRequest setOrder(HistoryOrder order) {
        this.order = order;
        return this;
    }

    public Integer getRev() {
        switch (order) {
            case SORT_ASC:
                return 1;
            case SORT_DESC:
                return 0;
        }
        return -1;
    }

    public Integer getPeerIdCanonical() {
        switch (peerType) {
            case USER:
                return peerId;
            case GROUP_CONVERSATION:
                return 2000000000 + peerId;
            case COMMUNITY:
                return -1 * Math.abs(peerId);
        }
        return 0;
    }
}
