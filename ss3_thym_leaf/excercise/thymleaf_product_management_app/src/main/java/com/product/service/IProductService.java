package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product finfById(int id);

    void save(Product product);

    void remove(int id);

    void update(int id, Product product);

    List<Product> findByName(String name);

}
