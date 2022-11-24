package com.orm_jpa_product_update.repository;

import com.orm_jpa_product_update.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void remove(int id);

    void update(int id, Product product);

    List<Product> findByName(String name);

}
