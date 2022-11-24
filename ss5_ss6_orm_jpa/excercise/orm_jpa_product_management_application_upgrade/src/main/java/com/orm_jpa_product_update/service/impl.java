package com.orm_jpa_product_update.service;

import com.orm_jpa_product_update.model.Product;
import com.orm_jpa_product_update.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class impl implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
