package com.gfb.hotelHero.controller;

import com.gfb.hotelHero.dao.AppSettingsDao;
import com.gfb.hotelHero.domain.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/settings")
public class SettingsController {

    @Autowired
    private AppSettingsDao appSettingsDao;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model) {
        AppSettings active = appSettingsDao.findActive();
        if (null == active)
            active = new AppSettings();
        model.addAttribute("settings", active);
        return "settings/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public ModelAndView submit(
            @ModelAttribute("settings") AppSettings settings,
            BindingResult result,
            ModelMap model
    ) {
        if (result.hasErrors()) {
            return new ModelAndView("error");
        }

        appSettingsDao.add(settings);

        model.addAttribute("avatarUrl", settings.getAvatarUrl());
        model.addAttribute("paymentRegexpList", settings.getPaymentRegexpList());

//        return "settings/form";
        return new ModelAndView("settings/form",
                "settings", settings);
    }

}
