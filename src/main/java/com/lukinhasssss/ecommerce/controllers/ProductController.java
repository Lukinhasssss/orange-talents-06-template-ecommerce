package com.lukinhasssss.ecommerce.controllers;

import com.lukinhasssss.ecommerce.dto.request.AddProductImagesRequest;
import com.lukinhasssss.ecommerce.dto.request.OpinionRequest;
import com.lukinhasssss.ecommerce.dto.request.RegisterProductRequest;
import com.lukinhasssss.ecommerce.entities.Opinion;
import com.lukinhasssss.ecommerce.entities.Product;
import com.lukinhasssss.ecommerce.entities.User;
import com.lukinhasssss.ecommerce.repositories.CategoryRepository;
import com.lukinhasssss.ecommerce.repositories.OpinionRepository;
import com.lukinhasssss.ecommerce.repositories.ProductRepository;
import com.lukinhasssss.ecommerce.utils.upload.FakeUploader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private FakeUploader fakeUploader;
    private OpinionRepository opinionRepository;

    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository, FakeUploader fakeUploader, OpinionRepository opinionRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.fakeUploader = fakeUploader;
        this.opinionRepository = opinionRepository;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid RegisterProductRequest request, @AuthenticationPrincipal User loggedUser) {
        Product product = request.toEntity(categoryRepository, loggedUser);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{productId}/images")
    public ResponseEntity<Void> insertImages(@PathVariable Long productId, @Valid AddProductImagesRequest request, @AuthenticationPrincipal User userAuthenticated) {
        Set<String> links = fakeUploader.send(request.getImages());

        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isEmpty())
            return ResponseEntity.notFound().build();

        Product product = optionalProduct.get();

        if (!product.isUserOwner(userAuthenticated))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        product.addImages(links);
        productRepository.save(product);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{productId}/opinions")
    public ResponseEntity<Void> insertOpinions(@PathVariable Long productId, @RequestBody @Valid OpinionRequest request, @AuthenticationPrincipal User user) {
        if (user == null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        Optional<Product> product = productRepository.findById(productId);

        if (product.isEmpty())
            return ResponseEntity.notFound().build();

        Opinion opinion = request.convertToEntity(product.get(), user);
        opinionRepository.save(opinion);
        return ResponseEntity.ok().build();
    }
}