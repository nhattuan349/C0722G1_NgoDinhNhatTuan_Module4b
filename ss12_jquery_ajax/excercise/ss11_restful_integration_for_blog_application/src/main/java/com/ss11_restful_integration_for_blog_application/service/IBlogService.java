package com.ss11_restful_integration_for_blog_application.service;

import com.ss11_restful_integration_for_blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {

    Page<Blog> findByAuthor(String authorSearch, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findByName(String keyword);
}
