package com.gfb.hotelHero.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GlobalVarsListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        context.setAttribute("username", System.getProperty("user.name"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }
}
