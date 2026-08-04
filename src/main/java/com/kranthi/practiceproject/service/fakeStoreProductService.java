package com.kranthi.practiceproject.service;

import com.kranthi.practiceproject.models.Product;
import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class fakeStoreProductService implements ProductService{

    public Product getSingleProduct(long id) {
        System.out.println("inside getting the single product method API");
        return null;
    }

    public List<Product> getAllProduct() {
        return List.of();
    }

    public Product createProduct(Product p) {
        return null;
    }
}
