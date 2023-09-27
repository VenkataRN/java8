package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @RequestMapping("/register")
    public String registerPage() {
        System.out.println("Entered into user-registration-page");
        return "user-registration-page";
    }

}
