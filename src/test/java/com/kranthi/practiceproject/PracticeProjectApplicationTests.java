package com.kranthi.practiceproject;

import com.kranthi.practiceproject.Respository.CategoryRepository;
import com.kranthi.practiceproject.Respository.ProductRepository;
import com.kranthi.practiceproject.Respository.Projections.ProductProjections;
import com.kranthi.practiceproject.models.Category;
import com.kranthi.practiceproject.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class PracticeProjectApplicationTests {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }
    @Test
    void testQueries(){
//        List<ProductProjections> products = productRepository.getByCategoryId(1L);
//        for(ProductProjections p:products){
//            System.out.println(p.getPrice());
//            System.out.println(p.getTitle());
//        }
        Category cat = categoryRepository.findById(1L).get();
        System.out.println(cat.getName());
        System.out.println("only main attributes is fetched");

        List<Product> prod = cat.getProduct();
        System.out.println(prod.size());
    }
}
