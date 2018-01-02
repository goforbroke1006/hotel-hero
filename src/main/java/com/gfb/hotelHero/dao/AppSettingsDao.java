package com.gfb.hotelHero.dao;

import com.gfb.hotelHero.domain.AppSettings;

import java.util.List;

public interface AppSettingsDao {

    List<AppSettings> findAll();

    AppSettings findActive();

    void add(AppSettings appSettings);

}
