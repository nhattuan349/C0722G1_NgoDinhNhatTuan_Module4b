package com.simple_dictionary_app.controller;

import com.simple_dictionary_app.service.IDistionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/distionary")
public class DistionaryController {

    @Autowired
    private IDistionaryService distionaryService;

    @GetMapping("")
    public String showList(){
        return "/list";
    }

    @PostMapping("result")
    public String result(@RequestParam String vocabulary, Model model){
        String result = distionaryService.search(vocabulary);
        model.addAttribute("result",result);
        return "/list";
    }



}
