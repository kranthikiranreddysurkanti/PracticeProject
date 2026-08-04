package com.kranthi.practiceproject.Controller;

import com.kranthi.practiceproject.models.Product;
import com.kranthi.practiceproject.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/products")
    public void createProduct(Product p){

    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        productService.getSingleProduct(id);
        return null;
    }
    @PutMapping("/products")
    public void updateProduct(Product p){

    }
    @DeleteMapping("/products")
    public void deleteProduct(Long id){

    }
}
