package com.gfb.hotelHero.controller;

import com.gfb.hotelHero.dao.ReceivingPointDao;
import com.gfb.hotelHero.domain.ReceivingPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/receiving-point")
public class ReceivingSideCRUDController {

    @Autowired
    private ReceivingPointDao receivingPointDao;

    @RequestMapping("/list")
    public String list(Model model) {
        List<ReceivingPoint> list = receivingPointDao.findAll();
        model.addAttribute("list", list);
        return "receiving-point/list";
    }

    @RequestMapping(value = "/form/create", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("point", new ReceivingPoint());
        return "receiving-point/form";
    }

    @RequestMapping(value = "/form/{id}/edit", method = RequestMethod.GET)
    public String form(@PathVariable(value = "id", required = false) String id, Model model) {
        ReceivingPoint point = receivingPointDao.find(Long.parseLong(id));
        model.addAttribute("point", point);
        return "receiving-point/form";
    }

    @RequestMapping(value = "/form/save", method = RequestMethod.POST)
    public String formSave(@ModelAttribute("point") ReceivingPoint point) {
        receivingPointDao.add(point);
        return "redirect:list";
    }

    @RequestMapping(value = "/form/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id", required = false) String id) {
        receivingPointDao.delete(Long.parseLong(id));
        return "redirect:list";
    }

}
