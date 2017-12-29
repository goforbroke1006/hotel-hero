package com.gfb.hotelHero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payments-accounting")
public class PaymentAccountingController {

    @RequestMapping(value = "/list")
    public String list(Model model) {
        return "payments-accounting/list";
    }

    @RequestMapping(value = "/vk-trace")
    public String vkTrace(Model model) {
        return "payments-accounting/vk-trace";
    }

}
