package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LCAppController {

    @RequestMapping("/")
    public String homePage(){
        return "home-page";
    }
}

