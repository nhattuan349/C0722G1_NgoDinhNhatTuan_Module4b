package com.ss13_spring_sercurity.repository;

import com.ss13_spring_sercurity.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Query(value="select * " +
            "from `student` " +
            "where name like concat('%', :name, '%')", nativeQuery = true)
    Page<Student> findByStudentNameContaining(Pageable pageable,@Param("name") String name);

}
