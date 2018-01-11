package com.gfb.hotelHero.dao.hibernate;

import com.gfb.hotelHero.dao.ReceivingPointDao;
import com.gfb.hotelHero.domain.ReceivingPoint;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReceivingPointDaoImpl
        extends BaseDao<ReceivingPoint, Long>
        implements ReceivingPointDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Long id) {
        super.deleteById(id);
    }

}
