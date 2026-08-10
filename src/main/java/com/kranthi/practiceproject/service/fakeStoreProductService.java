package com.kranthi.practiceproject.service;

import com.kranthi.practiceproject.DTO.FakeStoreProductDto;
import com.kranthi.practiceproject.models.Product;
import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class fakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public fakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getSingleProduct(long id) {
        System.out.println("inside getting the single product method API");
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        return fakeStoreProductDto.getProduct();
    }

    public List<Product> getAllProduct() {
        return List.of();
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

}
