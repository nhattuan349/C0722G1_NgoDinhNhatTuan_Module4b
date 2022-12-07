package com.ss13_spring_sercurity.controller;

import com.ss13_spring_sercurity.model.Student;
import com.ss13_spring_sercurity.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;


    @GetMapping("")
    public ModelAndView listStudents(@PageableDefault(value = 2) Pageable pageable,
                                     @RequestParam(defaultValue = "") String name) {
        ModelAndView modelAndView = new ModelAndView("views/student/list");
        modelAndView.addObject("students", studentService.findByName(pageable, name));
        return modelAndView;

    }



}
