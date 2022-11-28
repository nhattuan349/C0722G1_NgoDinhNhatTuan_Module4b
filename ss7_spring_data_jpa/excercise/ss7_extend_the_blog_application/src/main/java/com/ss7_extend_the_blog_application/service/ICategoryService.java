package com.ss7_extend_the_blog_application.service;

import com.ss7_extend_the_blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


public interface ICategoryService extends IGeneralService<Category> {

    Page<Category> findByNameCategory(Pageable pageable, String name);

}
