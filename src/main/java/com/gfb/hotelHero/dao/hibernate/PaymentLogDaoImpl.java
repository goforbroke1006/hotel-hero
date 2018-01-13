package com.gfb.hotelHero.dao.hibernate;

import com.gfb.hotelHero.dao.PaymentLogDao;
import com.gfb.hotelHero.domain.PaymentLog;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentLogDaoImpl extends BaseDao<PaymentLog, Long> implements PaymentLogDao {

}
