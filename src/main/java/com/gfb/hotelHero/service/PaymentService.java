package com.gfb.hotelHero.service;

import com.gfb.hotelHero.dao.PaymentLogDao;
import com.gfb.hotelHero.ddengi.DrebeDengiClient;
import com.gfb.hotelHero.ddengi.model.Record;
import com.gfb.hotelHero.ddengi.model.SetRecordListResponse;
import com.gfb.hotelHero.domain.PaymentLog;
import com.gfb.hotelHero.vkontakte.VkontakteClient;
import com.gfb.hotelHero.vkontakte.domain.messages.GetHistoryRequest;
import com.gfb.hotelHero.vkontakte.domain.messages.GetHistoryResponse;
import com.gfb.hotelHero.vkontakte.domain.messages.HistoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PaymentService {

    @Autowired
    private PaymentLogDao paymentLogDao;

    @Autowired
    private VkontakteClient vkontakteClient;

    @Autowired
    private DrebeDengiClient drebeDengiClient;

    public void loadAndPersistUpdates() {
        GetHistoryResponse history = vkontakteClient.getMessagesPort().getHistory(new GetHistoryRequest(
                2314852, GetHistoryRequest.PeerTypes.GROUP_CONVERSATION, 50, 100
        ));

        for (HistoryItem item : history.getItems()) {
            if (paymentLogDao.exists(item.getId()))
                continue;

            if (!relevantMessage(item.getMessage())) continue;

            PaymentLog log = new PaymentLog()
                    .setVkontakteMessageId(item.getId())
                    .setMessageText(item.getMessage());
            paymentLogDao.add(log);
        }
    }

    private boolean relevantMessage(String txt) {
        if (txt.contains("Тест")) return true; // TODO: fake analyse

        return false;
    }

    public void writeToDdengi(Long vkontakteMessageId) {
        PaymentLog log = paymentLogDao.find(vkontakteMessageId);
        writeToDdengi(log);
    }

    public void writeToDdengi(PaymentLog log) {
        Record record = new Record();
        parseMessage(log.getMessageText(), record);

        record.setClientId(log.getVkontakteMessageId());
        record.setCurrencyId(Record.RUSSIAN_RUBLE_ID);

        SetRecordListResponse response = drebeDengiClient.addRecordList(record);
        assert response != null;
    }

    private void parseMessage(String txt, Record record) {
        Pattern datePattern = Pattern.compile("([\\d]{1,2}.[\\d]{1,2}.[\\d]{4})");
        Matcher dateMatcher = datePattern.matcher(txt);
        if (dateMatcher.find()) {
            try {
                record.setOperationDate(
                        new SimpleDateFormat("dd.MM.yyyy")
                                .parse(dateMatcher.group(1))
                );
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        Pattern amountPattern = Pattern.compile("([\\d\\s,.]+)[\\s]*руб");
        Matcher amountMatcher = amountPattern.matcher(txt);
        if (amountMatcher.find()) {
            String amountStr = amountMatcher.group(1);
            amountStr = amountStr.replaceAll("[\\s]+", "");
            amountStr = amountStr.replaceAll(",", ".");
            record.setSum(Float.parseFloat(amountStr));
        }
    }

    public List<PaymentLog> getUnsentPaymentLogs() {
        return paymentLogDao.findUnsent();
    }

}
