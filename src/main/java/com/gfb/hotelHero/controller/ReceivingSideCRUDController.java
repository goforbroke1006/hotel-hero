package com.gfb.hotelHero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/receiving-size")
public class ReceivingSideCRUDController {

    @RequestMapping("/list")
    public String list() {
        return "receiving-size/list";
    }

}
