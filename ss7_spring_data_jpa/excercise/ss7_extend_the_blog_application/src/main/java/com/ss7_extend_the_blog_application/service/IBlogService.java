package com.ss7_extend_the_blog_application.service;

import com.ss7_extend_the_blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {

    Page<Blog> findByNameAndCategory(Pageable pageable,String author, String category);

}
