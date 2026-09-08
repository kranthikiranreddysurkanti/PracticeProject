package com.kranthi.practiceproject;

import com.kranthi.practiceproject.Respository.CategoryRepository;
import com.kranthi.practiceproject.Respository.ProductRepository;
import com.kranthi.practiceproject.Respository.Projections.ProductProjections;
import com.kranthi.practiceproject.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PracticeProjectApplicationTests {

    @Autowired
    private ProductRepository productRepository;
    @Test
    void contextLoads() {
    }
    @Test
    void testQueries(){
        List<ProductProjections> products = productRepository.getByCategoryId(1L);
        for(ProductProjections p:products){
            System.out.println(p.getPrice());
            System.out.println(p.getTitle());
        }
    }
}
