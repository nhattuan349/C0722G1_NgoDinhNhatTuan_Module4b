package com.ss13_spring_sercurity.service.impl;

import com.ss13_spring_sercurity.model.Student;
import com.ss13_spring_sercurity.repository.IStudentRepository;
import com.ss13_spring_sercurity.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {


    @Autowired
    private IStudentRepository studentRepository;


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void remove(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Page<Student> findByName(Pageable pageable, String name) {
        return studentRepository.findByStudentNameContaining(pageable, name);
    }
}
