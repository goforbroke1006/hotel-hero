package com.gfb.hotelHero.dao;

import com.gfb.hotelHero.domain.PaymentLog;

import java.util.List;

public interface PaymentLogDao {
    List<PaymentLog> findAll();

    void add(PaymentLog log);
}
