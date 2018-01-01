package com.gfb.hotelHero.vkontakte;

import com.gfb.hotelHero.vkontakte.domain.messages.GetHistoryRequest;
import com.gfb.hotelHero.vkontakte.domain.messages.GetHistoryResponse;

public class MessagesPort {
    private VkontakteClient client;

    public MessagesPort(VkontakteClient client) {
        this.client = client;
    }

    public GetHistoryResponse getHistory(GetHistoryRequest request) {
        return (GetHistoryResponse) client.exec(request);
    }
}
