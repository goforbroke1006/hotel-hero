package com.gfb.hotelHero.dao.hibernate;

import com.gfb.hotelHero.dao.PaymentLogDao;
import com.gfb.hotelHero.dao.hibernate.util.HibernateUtil;
import com.gfb.hotelHero.domain.PaymentLog;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PaymentLogDaoImpl implements PaymentLogDao {

//    @PersistenceContext
//    protected EntityManager em;

    public List<PaymentLog> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session
                .createQuery("SELECT _pl FROM com.gfb.hotelHero.domain.PaymentLog _pl")
                .list();
    }

    @Override
    public void add(PaymentLog log) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(log);
            session.flush();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
