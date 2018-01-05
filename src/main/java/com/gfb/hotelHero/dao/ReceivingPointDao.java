package com.gfb.hotelHero.dao;

import com.gfb.hotelHero.domain.ReceivingPoint;

import java.util.List;

public interface ReceivingPointDao {

    List<ReceivingPoint> findAll();

    ReceivingPoint find(Long id);

    void add(ReceivingPoint info);

    void edit(ReceivingPoint info);

    void delete(ReceivingPoint info);

    void delete(Long id);

}
