package com.kranthi.practiceproject.Respository;

import com.kranthi.practiceproject.Respository.Projections.ProductProjections;
import com.kranthi.practiceproject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //save


    //update

    //delete

    //get
    Product findByTitle(String title);

    @Query("select p.price as price, p.title as title from Product p where p.category.id =:categoryId")
    List<ProductProjections> getByCategoryId(@Param("categoryId")Long categoryId);

    @Query(value = "select * from product p where p.category_id =:categoryId",  nativeQuery = true)
    List<Product> getByCategoryIdNativeQuery(@Param("categoryId")Long categoryId);
    //getAll

}
