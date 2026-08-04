package com.kranthi.practiceproject.service;

import com.kranthi.practiceproject.models.Product;

import java.util.List;

public interface ProductService {
     Product getSingleProduct(long id);
     List<Product> getAllProduct();
     Product createProduct(Product p);
}
