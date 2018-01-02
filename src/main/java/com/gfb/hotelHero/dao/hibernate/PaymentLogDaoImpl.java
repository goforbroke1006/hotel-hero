package com.gfb.hotelHero.dao.hibernate;

import com.gfb.hotelHero.dao.PaymentLogDao;
import com.gfb.hotelHero.dao.hibernate.util.HibernateUtil;
import com.gfb.hotelHero.domain.PaymentLog;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentLogDaoImpl extends BaseDao<PaymentLog> implements PaymentLogDao {

    public List<PaymentLog> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session
                .createQuery("SELECT _pl FROM com.gfb.hotelHero.domain.PaymentLog _pl")
                .list();
    }

}
