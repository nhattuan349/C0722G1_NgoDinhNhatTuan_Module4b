package com.product.repository;

import com.product.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void remove(int id);

    void  update(int id, Product product);

    List<Product> findByName(String name);

}
