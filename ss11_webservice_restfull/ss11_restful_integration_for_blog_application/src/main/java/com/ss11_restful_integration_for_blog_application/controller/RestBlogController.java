package com.ss11_restful_integration_for_blog_application.controller;

import com.ss11_restful_integration_for_blog_application.dto.BlogDto;
import com.ss11_restful_integration_for_blog_application.dto.CategoryDto;
import com.ss11_restful_integration_for_blog_application.model.Blog;
import com.ss11_restful_integration_for_blog_application.model.Category;
import com.ss11_restful_integration_for_blog_application.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rest/blog/v1")
public class RestBlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> showDetailBlog(
        @PathVariable("id") Integer id
    ){
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()){
            return  new ResponseEntity<>(blog.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping
    public ResponseEntity<Blog> save(@RequestBody BlogDto blogDto) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int id,
                                           @RequestBody BlogDto blogDto){
        Optional<Blog> blogList = blogService.findById(id);
        if (!blogList.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto,blog);
        blogService.save(blog);
        return new ResponseEntity<>(blog,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> removeBlog(@PathVariable("id") int id){
        Blog blog = blogService.findById(id).get();
        blogService.remove(id);
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

}
