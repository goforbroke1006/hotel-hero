package com.gfb.hotelHero.dao.hibernate;

import com.gfb.hotelHero.dao.ReceivingPointDao;
import com.gfb.hotelHero.domain.ReceivingPoint;
import org.springframework.stereotype.Repository;

@Repository
public class ReceivingPointDaoImpl
        extends BaseDao<ReceivingPoint, Long>
        implements ReceivingPointDao {

    @Override
    public void delete(Long id) {
        super.deleteById(id);
    }

}
