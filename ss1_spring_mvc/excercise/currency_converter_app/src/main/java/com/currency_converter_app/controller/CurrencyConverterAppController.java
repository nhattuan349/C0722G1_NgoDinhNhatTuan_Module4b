package com.currency_converter_app.controller;

import com.currency_converter_app.service.ICurrencyConverterApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/app")
public class CurrencyConverterAppController {

    @Autowired
    private ICurrencyConverterApp currencyConverterApp;

    @GetMapping("")
    public String ShowList(){
        return"/list";
    }

    @PostMapping("/converter")
    public String result(@RequestParam(required = false,value = "usd") double usd, Model model){
        double result = currencyConverterApp.converter(usd);
        model.addAttribute("result", result);
        return "/list";
    }

}
