package com.gfb.hotelHero.dao.hibernate.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Properties;

public class HibernateUtil {
    private static final Logger LOGGER = Logger.getLogger(HibernateUtil.class);

    private static SessionFactory sessionFactory;

    /*static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            LOGGER.error(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }*/

    public static SessionFactory getSessionFactory() {
        if (null == sessionFactory) {
//            Configuration configuration = new Configuration();
//            configuration.configure();
//
//            Properties properties = configuration.getProperties();
//
//            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
