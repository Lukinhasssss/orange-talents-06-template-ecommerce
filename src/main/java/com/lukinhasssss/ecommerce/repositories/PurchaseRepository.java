package com.lukinhasssss.ecommerce.repositories;

import com.lukinhasssss.ecommerce.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
