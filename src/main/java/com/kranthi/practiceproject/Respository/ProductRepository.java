package com.kranthi.practiceproject.Respository;

import com.kranthi.practiceproject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //save


    //update

    //delete

    //get
    Product findByTitle(String title);

    //getAll

}
