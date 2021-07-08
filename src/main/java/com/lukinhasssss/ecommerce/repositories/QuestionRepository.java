package com.lukinhasssss.ecommerce.repositories;

import com.lukinhasssss.ecommerce.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
