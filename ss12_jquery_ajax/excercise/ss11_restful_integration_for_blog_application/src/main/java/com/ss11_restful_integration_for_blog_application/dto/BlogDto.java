package com.ss11_restful_integration_for_blog_application.dto;

import com.ss11_restful_integration_for_blog_application.model.Category;

public class BlogDto {

    private Integer id;
    private String author;
    private Integer price;
    private String status ;
    private Category category;

    public BlogDto() {
    }

    public BlogDto(Integer id, String author, Integer price, String status, Category category) {
        this.id = id;
        this.author = author;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
