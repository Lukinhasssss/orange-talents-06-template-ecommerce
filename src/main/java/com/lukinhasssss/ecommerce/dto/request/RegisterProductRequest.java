package com.lukinhasssss.ecommerce.dto.request;

import com.lukinhasssss.ecommerce.config.validation.CheckIfIdExists;
import com.lukinhasssss.ecommerce.entities.Category;
import com.lukinhasssss.ecommerce.entities.Product;
import com.lukinhasssss.ecommerce.entities.User;
import com.lukinhasssss.ecommerce.repositories.CategoryRepository;
import com.lukinhasssss.ecommerce.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class RegisterProductRequest {

    @NotBlank @NotEmpty
    private String name;

    @NotNull
    private BigDecimal value;

    @NotNull @PositiveOrZero
    private Integer availableQuantity;

    @NotBlank @NotEmpty @Size(max = 1000)
    private String description;

    @NotNull @CheckIfIdExists(domainClass = Category.class, fieldName = "id", message = "Não existe categoria com este id")
    private Long categoryId;

    @Size(min = 3) @Valid
    private Set<ProductCharacteristicsRequest> characteristics = new HashSet<>();

    public RegisterProductRequest(String name, BigDecimal value, Integer availableQuantity, String description, Long categoryId,
                              Set<ProductCharacteristicsRequest> characteristics) {
        this.name = name;
        this.value = value;
        this.availableQuantity = availableQuantity;
        this.description = description;
        this.categoryId = categoryId;
        this.characteristics.addAll(characteristics);
    }

    public Product toEntity(CategoryRepository categoryRepository, User user) {
        Category category = categoryRepository.getById(categoryId);
        return new Product(name, value, availableQuantity, description, category, characteristics, user);
    }

}
