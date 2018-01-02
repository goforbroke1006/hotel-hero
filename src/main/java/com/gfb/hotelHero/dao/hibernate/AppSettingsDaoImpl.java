package com.gfb.hotelHero.dao.hibernate;

import com.gfb.hotelHero.dao.AppSettingsDao;
import com.gfb.hotelHero.dao.hibernate.util.HibernateUtil;
import com.gfb.hotelHero.domain.AppSettings;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "appSettingsDao")
public class AppSettingsDaoImpl extends BaseDao<AppSettings> implements AppSettingsDao {

    @Override
    public List<AppSettings> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session
                .createQuery("SELECT _as FROM com.gfb.hotelHero.domain.AppSettings _as")
                .list();
    }

    @Override
    public AppSettings findActive() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List list = session
                .createQuery("SELECT _as FROM com.gfb.hotelHero.domain.AppSettings _as " +
                        "ORDER BY id DESC " +
                        "LIMIT 1")
                .list();
        return list.size() > 0 ? (AppSettings) list.get(0) : null;
    }
}
