package com.gfb.hotelHero.listener;

import com.gfb.hotelHero.dao.AppSettingsDao;
import com.gfb.hotelHero.domain.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Component
public class GlobalVarsListener implements ServletContextListener {

    @Autowired
    private AppSettingsDao appSettingsDao;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        ServletContext context = event.getServletContext();

        context.setAttribute("applicationLabel", "Hotel hero");

        context.setAttribute("username", System.getProperty("user.name"));

        AppSettings settings = appSettingsDao.findActive();
        if (null != settings) {
            context.setAttribute("userAvatarUrl", settings.getAvatarUrl());
        }

        if (null == settings || null == settings.getDateFormat() || settings.getDateFormat().isEmpty()) {
            context.setAttribute("applicationDateFormat", "yyyy-mm-dd");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

}
