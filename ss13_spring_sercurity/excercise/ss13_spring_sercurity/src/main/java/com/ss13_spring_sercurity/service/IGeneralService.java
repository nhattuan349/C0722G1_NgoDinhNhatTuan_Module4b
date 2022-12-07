package com.ss13_spring_sercurity.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {


    List<T> findAll();

    Optional<T> findById(int id);

    void save(T t);

    void remove(int id);

}
