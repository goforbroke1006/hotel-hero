package com.gfb.hotelHero.controller;

import com.gfb.hotelHero.domain.Person;
import com.gfb.hotelHero.domain.RightToStayConfirmingDocument;
import com.gfb.hotelHero.service.FillXmlBlankWithRegistrationInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/registration")
public class RegistrationFormController {

    private static final Logger LOGGER = Logger.getLogger(RegistrationFormController.class);

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
//        sdf.setLenient(true);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("stayConfirmingDocumentTypes", RightToStayConfirmingDocument.Types.values());
        model.addAttribute("personPurposes", Person.Purposes.values());
        return "reg-form/index";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String saveForm(
            @ModelAttribute("person") Person person,
            BindingResult bindingResult,
            ModelMap model
    ) {
        System.out.println(person.getFirstName());

        model.addAttribute("person", person);
        model.addAttribute("stayConfirmingDocumentTypes", RightToStayConfirmingDocument.Types.values());
        model.addAttribute("personPurposes", Person.Purposes.values());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String newFileName = System.getProperty("user.home") + File.separator
                + dateFormat.format(new Date()) + "-" + person.getLastName() + "-" + person.getFirstName()
                + ".xls";
        URL resource = getClass().getClassLoader().getResource("blank-form.xls");
        if (resource != null) {
            try {
                new FillXmlBlankWithRegistrationInfoService().writeData(
                        new File(resource.getFile()),
                        new File(newFileName),
                        person,
                        false
                );
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.error(e.getMessage());
            }
        } else
            LOGGER.error("Blank XML form file not found!");

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
