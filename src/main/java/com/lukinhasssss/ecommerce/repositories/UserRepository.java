package com.lukinhasssss.ecommerce.repositories;

import com.lukinhasssss.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
