package com.ss11_restful_integration_for_blog_application.controller;

import com.ss11_restful_integration_for_blog_application.dto.CategoryDto;
import com.ss11_restful_integration_for_blog_application.model.Blog;
import com.ss11_restful_integration_for_blog_application.model.Category;
import com.ss11_restful_integration_for_blog_application.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/rest/category/v1")
public class RestCategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>(categories, HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Set<Blog>> showDetailCategory(@PathVariable("id") Integer id){
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()){
            return new ResponseEntity<>(category.get().getBlogs(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
