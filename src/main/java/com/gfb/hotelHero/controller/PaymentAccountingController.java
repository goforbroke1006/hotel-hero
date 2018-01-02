package com.gfb.hotelHero.controller;

import com.gfb.hotelHero.dao.PaymentLogDao;
import com.gfb.hotelHero.ddengi.DrebeDengiClient;
import com.gfb.hotelHero.ddengi.model.GetRecordListRequest;
import com.gfb.hotelHero.ddengi.model.GetRecordListResponse;
import com.gfb.hotelHero.ddengi.model.Item;
import com.gfb.hotelHero.domain.PaymentLog;
import com.gfb.hotelHero.vkontakte.VkontakteClient;
import com.gfb.hotelHero.vkontakte.domain.messages.GetHistoryRequest;
import com.gfb.hotelHero.vkontakte.domain.messages.GetHistoryResponse;
import com.gfb.hotelHero.vkontakte.domain.messages.HistoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/payments-accounting")
public class PaymentAccountingController {

    @Autowired
    private PaymentLogDao paymentLogDao;

    @Autowired
    private DrebeDengiClient drebeDengiClient;

    @Autowired
    private VkontakteClient vkontakteClient;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<PaymentLog> paymentLogList = paymentLogDao.findAll();
        model.addAttribute("paymentLogs", paymentLogList);

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

        GetHistoryRequest hr = new GetHistoryRequest(2314852, 50, GetHistoryRequest.PeerTypes.GROUP_CONVERSATION);
        GetHistoryResponse history = vkontakteClient.getMessagesPort().getHistory(hr);

        Pattern regexp = Pattern.compile("[\\w\\s]+[\\d\\s\\,]+руб.[\\s]+([\\d]{2}.[\\d]{2}.[\\d]{4})[\\s]+[\\d\\w\\sа-яА-ЯёЁ]+");
        for (HistoryItem item : history.getItems()) {
            if (regexp.matcher(item.getMessage()).matches()) {
                PaymentLog paymentLog = new PaymentLog();
                paymentLog.setVkontakteMessageId(item.getId()).setMessageText(item.getMessage());
                paymentLogDao.add(paymentLog);
            }
        }

        model.addAttribute("history", history);

        return "payments-accounting/list";
    }

    @RequestMapping(value = "/vk-trace")
    public String vkTrace(Model model) {
        return "payments-accounting/vk-trace";
    }

}
