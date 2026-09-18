package com.kranthi.practiceproject.service;

import com.kranthi.practiceproject.DTO.FakeStoreProductDto;
import com.kranthi.practiceproject.Exceptions.ProductNotFoundException;
import com.kranthi.practiceproject.models.Product;
import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service("fakeStoreProductService")
public class fakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public fakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getSingleProduct(long id) throws ProductNotFoundException {
        System.out.println("inside getting the single product method API");
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("product is not available in fakestore");
        }
        return fakeStoreProductDto.getProduct();
    }

    public List<Product> getAllProduct() {
        FakeStoreProductDto[] response = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        if(response!=null){
            List<Product> products = new ArrayList<>();
            for(FakeStoreProductDto fakeStoreProductDto:response){
                products.add(fakeStoreProductDto.getProduct());
            }
            System.out.println(products.size());
            return products;
        }
        return null;

    }

    @Override
    public Product createProduct(Long id, String Title, String description, Double price,String imageUrl, String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(Title);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setCategory(category);
        FakeStoreProductDto fakeStoreProductDto1 =
                restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);
        return fakeStoreProductDto1.getProduct();
    }

    @Override
    public void updateProduct(Long id, String Title, String description, Double price, String imageUrl, String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(Title);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setCategory(category);
        restTemplate.put("https://fakestoreapi.com/products/" + id, fakeStoreProductDto);
        System.out.println("inside updating the product method API");
        System.out.println("updated the product with id " + id);
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
        System.out.println("inside deleting the product method API");
        System.out.println("deleted the given product with id " + id);
    }

}
