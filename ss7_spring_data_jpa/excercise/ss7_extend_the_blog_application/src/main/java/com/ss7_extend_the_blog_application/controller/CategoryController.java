package com.ss7_extend_the_blog_application.controller;

import com.ss7_extend_the_blog_application.model.Blog;
import com.ss7_extend_the_blog_application.model.Category;
import com.ss7_extend_the_blog_application.service.IBlogService;
import com.ss7_extend_the_blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;


    @GetMapping("")
    public ModelAndView showListBlog(@PageableDefault(value = 5) Pageable pageable,
                                     @RequestParam(defaultValue = "") String name){
        ModelAndView modelAndView = new ModelAndView("views/category/list");
        modelAndView.addObject("categories", categoryService.findByNameCategory(pageable, name));
        modelAndView.addObject("blogs",blogService.findAll());
        return  modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("views/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
            ModelAndView modelAndView = new ModelAndView("views/category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("views/category/edit");
            modelAndView.addObject("category", category.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("views/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "category updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("views/category/delete");
            modelAndView.addObject("category", category.get());
            return modelAndView;

        } else {
            return new ModelAndView("views/category/error.404");
        }
    }

    @PostMapping("/delete")
    public String deleteCategory(@ModelAttribute("category") Category category) {
        categoryService.remove(category.getId());
        return "redirect:/category";
    }

}
