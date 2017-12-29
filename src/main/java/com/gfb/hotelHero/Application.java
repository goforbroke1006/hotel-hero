package com.gfb.hotelHero;

import com.gfb.hotelHero.server.WebServer;

public class Application {
    public static void main(String[] args) throws Exception {
        new WebServer(8080).start();
    }
}
