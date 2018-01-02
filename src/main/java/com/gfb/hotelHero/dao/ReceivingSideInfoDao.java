package com.gfb.hotelHero.dao;

import com.gfb.hotelHero.domain.ReceivingSideInfo;

import java.util.List;

public interface ReceivingSideInfoDao {

    List<ReceivingSideInfo> findAll();

    void add(ReceivingSideInfo info);

    void edit(ReceivingSideInfo info);

    void delete(ReceivingSideInfo info);

}
