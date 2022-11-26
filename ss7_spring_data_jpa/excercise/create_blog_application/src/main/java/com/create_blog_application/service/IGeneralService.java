package com.create_blog_application.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {

    List<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void removed(Long id);

}
