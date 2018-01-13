package com.gfb.hotelHero.dao;

import com.gfb.hotelHero.domain.PaymentLog;

import java.util.List;

public interface PaymentLogDao {
    List<PaymentLog> findAll();

    List<PaymentLog> findUnsent();

    PaymentLog find(Long id);

    void add(PaymentLog log);

    boolean exists(Long vkMessageId);
}
