package com.kranthi.practiceproject.Controller;

import com.kranthi.practiceproject.DTO.ErrorDTO;
import com.kranthi.practiceproject.Exceptions.ProductNotFoundException;
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
    public Product createProduct(@RequestBody Product product){
        Product p = productService.createProduct(product.getId(), product.getTitle(), product.getDescription(), product.getPrice(),product.getImageUrl(), product.getCategory().getName());
        return p;
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        System.out.println("starting the api");
        Product p = productService.getSingleProduct(id);
        System.out.println("ending the api");
        return p;
    }
    @PutMapping("/products")
    public void updateProduct(Product p){

    }
    @DeleteMapping("/products")
    public void deleteProduct(Long id){

    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleProductNotFoundException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(e.getMessage());
        return errorDTO;
    }
}
