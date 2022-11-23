package com.product.repository.impl;

import com.product.model.Product;
import com.product.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"Nước chanh",10000,15,"chanh xanh"));
        products.put(2, new Product(2,"Nước cam",10000,15,"cam Tiên Phước"));
        products.put(3, new Product(3,"Nước ổi",10000,15,"Ổi xanh"));
        products.put(4, new Product(4,"Nước bưởi",10000,15,"Bưởi năm roi"));
        products.put(5, new Product(5,"Nước cốc",10000,15,"Cốc"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> list = new  ArrayList<>();
            for (Product product : products.values())
                if (product.getName().contains(name)) {
                    list.add(product);
                }
        return list;
    }
}
