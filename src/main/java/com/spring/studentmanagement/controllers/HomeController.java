package com.spring.studentmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(path = "/home")
    public String getHomeView() {

        return "index";
    }

    @GetMapping(path = "/terms")
    public String termsOfService() {
        return "terms";
    }
}
