package com.ss11_restful_integration_for_blog_application.dto;

import com.ss11_restful_integration_for_blog_application.model.Blog;

import java.util.Set;

public class CategoryDto {

    private Integer id;
    private String name;
    private Set<Blog> blogs;

    public CategoryDto() {
    }

    public CategoryDto(Integer id, String name, Set<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
