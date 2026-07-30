package com.kranthi.practiceproject.Controller;

import com.kranthi.practiceproject.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    public void createProduct(Product p){

    }

    public Product getProduct(Long id){
        return null;
    }
}
