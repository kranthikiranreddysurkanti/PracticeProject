package com.kranthi.practiceproject.Respository;

import com.kranthi.practiceproject.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
