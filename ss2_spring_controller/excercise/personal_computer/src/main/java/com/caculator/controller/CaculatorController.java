package com.caculator.controller;

import com.caculator.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/caculator")
public class CaculatorController {

    @Autowired
    private ICaculatorService caculatorService;

    @GetMapping("")
    public String showList(){
        return "/list";
    }

    @GetMapping("/result")
    public String result(
                            @RequestParam(value = "firstOperand") double firstOperand,
                            @RequestParam(value = "secondOperand") double secondOperand,
                            @RequestParam(value = "operator") String operator,
                            Model model
    ){
        model.addAttribute("firstOperand",firstOperand);
        model.addAttribute("secondOperand",secondOperand);
        model.addAttribute("operator",operator);
        double result = caculatorService.caculator(firstOperand,secondOperand,operator);
        model.addAttribute("result",result);
        return "/list";
    }

}
