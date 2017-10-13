package com.gfb.hotelHero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registration-form")
public class RegistrationFormController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
//        m.addAttribute("username", System.getProperty("user.name"));
        return "reg-form/index";
    }

}
