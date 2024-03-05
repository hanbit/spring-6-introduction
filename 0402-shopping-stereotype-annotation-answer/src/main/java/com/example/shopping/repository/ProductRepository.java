package com.example.shopping.repository;

import com.example.shopping.entity.Product;

public interface ProductRepository {
    Product selectById(String id);

    boolean update(Product product);
}
