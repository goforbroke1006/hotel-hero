package com.gfb.hotelHero.controller;

import com.gfb.hotelHero.ddengi.DrebeDengiClient;
import com.gfb.hotelHero.ddengi.model.GetRecordListRequest;
import com.gfb.hotelHero.ddengi.model.GetRecordListResponse;
import com.gfb.hotelHero.ddengi.model.Item;
import com.gfb.hotelHero.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/payments-accounting")
public class PaymentAccountingController {

    @Autowired
    private DrebeDengiClient drebeDengiClient;

    @Autowired
    private PaymentService paymentLogService;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        paymentLogService.loadAndPersistUpdates();
        model.addAttribute("unsentLogs", paymentLogService.getUnsentPaymentLogs());

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

        return "payments-accounting/list";
    }

    @RequestMapping(value = "/log/{vkontakteMessageId}/approve")
    public String approve(@PathVariable String vkontakteMessageId) {
        paymentLogService.writeToDdengi(Long.valueOf(vkontakteMessageId));
        return "redirect:list";
    }

    @RequestMapping(value = "/vk-trace")
    public String vkTrace(Model model) {
        return "payments-accounting/vk-trace";
    }

}
