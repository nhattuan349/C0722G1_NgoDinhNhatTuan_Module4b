package com.ss13_spring_sercurity.service;

import com.ss13_spring_sercurity.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService extends IGeneralService<Student> {


    Page<Student> findByName(Pageable pageable, String name );

}
