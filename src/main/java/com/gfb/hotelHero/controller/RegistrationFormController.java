package com.gfb.hotelHero.controller;

import com.gfb.hotelHero.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationFormController {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String index() {
        return "reg-form/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveForm(
            @ModelAttribute("person") Person person,
            BindingResult bindingResult
    ) {
        System.out.println(person.getFirstName());

//        m.addAttribute("username", System.getProperty("user.name"));
        return "reg-form/index";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String settings() {
        return "reg-form/settings";
    }
    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public String settingsSave() {
        return "reg-form/settings";
    }
}
