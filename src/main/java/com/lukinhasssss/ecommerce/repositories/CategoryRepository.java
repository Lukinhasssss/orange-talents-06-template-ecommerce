package com.lukinhasssss.ecommerce.repositories;

import com.lukinhasssss.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
