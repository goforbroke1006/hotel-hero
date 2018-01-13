package com.gfb.hotelHero.controller;

import com.gfb.hotelHero.ddengi.model.Record;
import com.gfb.hotelHero.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payments-accounting")
public class PaymentAccountingController {

//    @Autowired
//    private PaymentLogDao paymentLogDao;
//
//    @Autowired
//    private DrebeDengiClient drebeDengiClient;
//
//    @Autowired
//    private VkontakteClient vkontakteClient;

    @Autowired
    private PaymentService paymentLogService;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        /*List<PaymentLog> paymentLogList = paymentLogDao.findAll();
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

        GetHistoryRequest hr = new GetHistoryRequest(2314852, GetHistoryRequest.PeerTypes.GROUP_CONVERSATION, 50, 100);
        GetHistoryResponse history = vkontakteClient.getMessagesPort().getHistory(hr);

        Pattern regexp = Pattern.compile("[\\w\\s]+[\\d\\s,]+руб.[\\s]+([\\d]{2}.[\\d]{2}.[\\d]{4})[\\s]+[\\d\\w\\sа-яА-ЯёЁ]+");
        for (HistoryItem item : history.getItems()) {
            if (regexp.matcher(item.getMessage()).matches()) {
                PaymentLog paymentLog = new PaymentLog();
                paymentLog.setVkontakteMessageId(item.getId()).setMessageText(item.getMessage());
                paymentLogDao.add(paymentLog);
            }
        }

        model.addAttribute("history", history);*/

        paymentLogService.loadAndPersistUpdates();
        model.addAttribute("unsentLogs", paymentLogService.getUnsentPaymentLogs());

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
