package com.md4_casestudy_furame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
    @GetMapping("/")
    public String showHomePage() { return "views/home";}


    @GetMapping("/login")
    public String ShowLoginPage() { return "views/myLogin";}
}
