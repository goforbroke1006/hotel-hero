package com.gfb.hotelHero.dao.hibernate;

import com.gfb.hotelHero.dao.PaymentLogDao;
import com.gfb.hotelHero.domain.PaymentLog;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentLogDaoImpl extends BaseDao<PaymentLog, Long> implements PaymentLogDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<PaymentLog> findUnsent() {
        return sessionFactory.openSession()
                .createQuery("FROM PaymentLog WHERE moved = FALSE").list();
    }

    @Override
    public boolean exists(Long vkMessageId) {
        Session session = sessionFactory.openSession();
        return session.createQuery("FROM PaymentLog WHERE vkontakteMessageId = :vkmid")
                .setParameter("vkmid", vkMessageId).list().size() > 0;
    }

}
