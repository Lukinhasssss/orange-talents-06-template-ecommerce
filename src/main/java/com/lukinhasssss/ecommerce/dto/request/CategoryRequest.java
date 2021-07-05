package com.lukinhasssss.ecommerce.dto.request;

import com.lukinhasssss.ecommerce.config.validation.CheckIfIdExists;
import com.lukinhasssss.ecommerce.config.validation.UniqueValue;
import com.lukinhasssss.ecommerce.entities.Category;
import com.lukinhasssss.ecommerce.repositories.CategoryRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CategoryRequest {

    @NotEmpty @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name", message = "Esta categoria já existe")
    private String name;

    @CheckIfIdExists(domainClass = Category.class, fieldName = "id", message = "Não existe categoria com esse id")
    private Long idMotherCategory;

    public String getName() {
        return name;
    }

    public Long getIdMotherCategory() {
        return idMotherCategory;
    }

    public Category convertToEntity(CategoryRepository categoryRepository) {
        Category category = null;

        if (idMotherCategory != null) {
            category = categoryRepository.getById(idMotherCategory);
        }
        return new Category(name, category);
    }

}
