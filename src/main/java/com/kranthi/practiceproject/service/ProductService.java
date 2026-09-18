package com.kranthi.practiceproject.service;

import com.kranthi.practiceproject.Exceptions.ProductNotFoundException;
import com.kranthi.practiceproject.models.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
     Product getSingleProduct(long id) throws ProductNotFoundException;
     List<Product> getAllProduct();
     Product createProduct(Long id, String Title, String description, Double price,String imageUrl, String category);
     void updateProduct(Long id, String Title, String description, Double price,String imageUrl, String category);
     void deleteProduct(Long id);
}
