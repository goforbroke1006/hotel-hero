package com.gfb.hotelHero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model m) {
//        m.addAttribute("username", System.getProperty("user.name"));
        m.addAttribute("username", "GFB");
        return "index/index";
    }

}
