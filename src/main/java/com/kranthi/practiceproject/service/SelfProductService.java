package com.kranthi.practiceproject.service;

import com.kranthi.practiceproject.Exceptions.ProductNotFoundException;
import com.kranthi.practiceproject.Respository.CategoryRepository;
import com.kranthi.practiceproject.Respository.ProductRepository;
import com.kranthi.practiceproject.models.Category;
import com.kranthi.practiceproject.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        Optional<Product> p = productRepository.findById(id);
        if(p.isPresent()) {
            return p.get();
        }
        throw new ProductNotFoundException("Product is not found in database");

    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Product createProduct(Long id, String Title, String description, Double price, String imageUrl, String category) {
        Product p = new Product();
        Category newCat = categoryRepository.findByName(category);
        if(newCat == null){
            Category newCat1 = new Category();
            newCat1.setName(category);
            Category newRow = categoryRepository.save(newCat1);
            p.setCategory(newRow);
        }else{
            p.setCategory(newCat);
        }
        p.setTitle(Title);
        p.setDescription(description);
        p.setPrice(price);
        p.setImageUrl(imageUrl);
        Product prod = productRepository.save(p);
        return prod;
    }
}
