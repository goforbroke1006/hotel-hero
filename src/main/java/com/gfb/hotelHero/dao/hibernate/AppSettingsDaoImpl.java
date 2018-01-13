package com.gfb.hotelHero.dao.hibernate;

import com.gfb.hotelHero.dao.AppSettingsDao;
import com.gfb.hotelHero.domain.AppSettings;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "appSettingsDao")
public class AppSettingsDaoImpl extends BaseDao<AppSettings, Long> implements AppSettingsDao {

    @Override
    public List<AppSettings> findAll() {
        Session session = sessionFactory.openSession();
        return session
                .createQuery("SELECT _as FROM com.gfb.hotelHero.domain.AppSettings _as")
                .list();
    }

    @Override
    public AppSettings findActive() {
        Session session = sessionFactory.openSession();
        List list = session
                .createQuery(
                        "SELECT _as FROM com.gfb.hotelHero.domain.AppSettings _as ORDER BY id DESC")
                .setMaxResults(1)
                .list();
        return list.size() > 0 ? (AppSettings) list.get(0) : null;
    }
}
