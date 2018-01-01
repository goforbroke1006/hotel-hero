package com.gfb.hotelHero.controller;

import com.gfb.hotelHero.ddengi.DrebeDengiClient;
import com.gfb.hotelHero.ddengi.model.GetRecordListRequest;
import com.gfb.hotelHero.ddengi.model.GetRecordListResponse;
import com.gfb.hotelHero.ddengi.model.Item;
import com.gfb.hotelHero.vkontakte.VkontakteClient;
import com.gfb.hotelHero.vkontakte.domain.messages.GetHistoryRequest;
import com.gfb.hotelHero.vkontakte.domain.messages.GetHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.MalformedURLException;
import java.util.Arrays;

@Controller
@RequestMapping("/payments-accounting")
public class PaymentAccountingController {

    @Autowired
    private DrebeDengiClient drebeDengiClient;

    @Autowired
    private VkontakteClient vkontakteClient;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        GetRecordListRequest request = new GetRecordListRequest();
        request.getParams().getItems().addAll(Arrays.asList(new Item[]{
                new Item("is_report", false),
                new Item("is_show_duty", true),
                new Item("r_period", 8),
                new Item("r_how", 1),
                new Item("r_what", 6),
                new Item("r_currency", 0),
                new Item("r_is_place", 0),
                new Item("r_is_tag", 0),
        }));
        GetRecordListResponse o = drebeDengiClient.getRecordList(request);
        model.addAttribute("records", o);

        GetHistoryRequest hr = new GetHistoryRequest(2314852, 49, GetHistoryRequest.PeerTypes.GROUP_CONVERSATION);
        GetHistoryResponse history = vkontakteClient.getMessagesPort().getHistory(hr);
        model.addAttribute("history", history);

        return "payments-accounting/list";
    }

    @RequestMapping(value = "/vk-trace")
    public String vkTrace(Model model) {
        return "payments-accounting/vk-trace";
    }

}
