package com.ss11_restful_integration_for_blog_application.repository;

import com.ss11_restful_integration_for_blog_application.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
