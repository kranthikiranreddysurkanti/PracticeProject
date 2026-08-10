package com.kranthi.practiceproject.service;

import com.kranthi.practiceproject.models.Product;

import java.util.List;

public interface ProductService {
     Product getSingleProduct(long id);
     List<Product> getAllProduct();
     Product createProduct(Long id, String Title, String description, Double price,String imageUrl, String category);
}
