package com.kranthi.practiceproject.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable("id") Long id){
        return "In the get product API to get product with id = " + id;
    }
}
