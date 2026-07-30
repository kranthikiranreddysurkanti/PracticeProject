package com.kranthi.practiceproject.Controller;

import com.kranthi.practiceproject.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @PostMapping("/products")
    public void createProduct(Product p){

    }
    @PutMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return null;
    }
    @GetMapping("/products")
    public void updateProduct(Product p){

    }
    @DeleteMapping("/products")
    public void deleteProduct(Long id){

    }
}
