package com.kranthi.practiceproject.Controller;

import com.kranthi.practiceproject.DTO.ErrorDTO;
import com.kranthi.practiceproject.Exceptions.ProductNotFoundException;
import com.kranthi.practiceproject.models.Product;
import com.kranthi.practiceproject.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        System.out.println("starting the api");
        Product p = productService.getSingleProduct(id);
        System.out.println("ending the api");
        ResponseEntity<Product> response = new ResponseEntity<>(
                p, HttpStatus.OK
        );
        return response;
    }
    @PutMapping("/products")
    public void updateProduct(Product p){

    }
    @DeleteMapping("/products")
    public void deleteProduct(Long id){

    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(e.getMessage());
        ResponseEntity<ErrorDTO> response = new ResponseEntity<>(
                errorDTO, HttpStatus.NOT_FOUND
        );
        return response;
    }
}
