package com.ss7_extend_the_blog_application.repository;

import com.ss7_extend_the_blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select c.* " +
            "from `category` c " +
            "where name like CONCAT('%', :name,'%') ",nativeQuery = true)
    Page<Category>findByNameCategory(Pageable pageable,
                                     @Param("name") String name);

}
