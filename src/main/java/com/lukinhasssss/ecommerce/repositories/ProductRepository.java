package com.lukinhasssss.ecommerce.repositories;

import com.lukinhasssss.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
