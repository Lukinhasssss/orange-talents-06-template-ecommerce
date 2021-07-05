package com.lukinhasssss.ecommerce.controllers;

import com.lukinhasssss.ecommerce.dto.request.CategoryRequest;
import com.lukinhasssss.ecommerce.entities.Category;
import com.lukinhasssss.ecommerce.repositories.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CategoryRequest request) {
        Category category = request.convertToEntity(categoryRepository);
        categoryRepository.save(category);
        return ResponseEntity.ok().build();
    }
}
