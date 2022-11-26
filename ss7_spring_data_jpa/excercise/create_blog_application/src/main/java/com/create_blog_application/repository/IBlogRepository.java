package com.create_blog_application.repository;

import com.create_blog_application.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {

    @Query(value = "select b.* " +
            "from `blog` b " +
            "where  author like CONCAT('%', :author, '%');",nativeQuery = true)
    List<Blog> findByName(@Param("author") String author);

}
