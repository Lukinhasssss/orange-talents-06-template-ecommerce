package com.lukinhasssss.ecommerce.repositories;

import com.lukinhasssss.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

}
