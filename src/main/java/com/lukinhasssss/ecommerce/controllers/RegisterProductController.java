package com.lukinhasssss.ecommerce.controllers;

import com.lukinhasssss.ecommerce.dto.request.RegisterProductRequest;
import com.lukinhasssss.ecommerce.entities.Product;
import com.lukinhasssss.ecommerce.entities.User;
import com.lukinhasssss.ecommerce.repositories.CategoryRepository;
import com.lukinhasssss.ecommerce.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class RegisterProductController {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public RegisterProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid RegisterProductRequest request, @AuthenticationPrincipal User loggedUser) {
        Product product = request.toEntity(categoryRepository, loggedUser);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
}
