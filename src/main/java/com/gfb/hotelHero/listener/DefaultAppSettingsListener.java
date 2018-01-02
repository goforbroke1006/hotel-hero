package com.gfb.hotelHero.listener;

import com.gfb.hotelHero.dao.AppSettingsDao;
import com.gfb.hotelHero.domain.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Component
public class DefaultAppSettingsListener implements ServletContextListener {

    @Autowired
    private AppSettingsDao appSettingsDao;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        if (appSettingsDao.findAll().size() == 0) {
            AppSettings settings = new AppSettings();
            settings.setPaymentRegexpList(
                    "[\\w\\s]+[\\d\\s\\,]+руб.[\\s]+([\\d]{2}.[\\d]{2}.[\\d]{4})[\\s]+[\\d\\w\\sа-яА-ЯёЁ]+" +
                    "\n" +
                    "[\\d]+[\\s]+руб[\\s]+#[\\d]+[\\d\\w\\sа-яА-ЯёЁ]+");
            appSettingsDao.add(settings);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

}
