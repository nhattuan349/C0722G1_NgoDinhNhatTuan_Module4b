package com.create_blog_application.service;

import com.create_blog_application.model.Blog;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {

    List<Blog> findByName(@Param("author") String author);

}
