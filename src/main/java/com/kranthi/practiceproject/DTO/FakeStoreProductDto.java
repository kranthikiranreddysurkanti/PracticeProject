package com.kranthi.practiceproject.DTO;

import com.kranthi.practiceproject.models.Category;
import com.kranthi.practiceproject.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    public Product getProduct(){
        Product p = new Product();
        p.setId(id);
        p.setTitle(title);
        p.setPrice(price);
        p.setDescription(description);
        p.setImageUrl(image);
        Category cat = new Category();
        cat.setName(category);
        p.setCategory(cat);
        return p;
    }
}
