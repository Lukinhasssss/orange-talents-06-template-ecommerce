package com.lukinhasssss.ecommerce.dto.request;

import com.lukinhasssss.ecommerce.entities.Product;
import com.lukinhasssss.ecommerce.entities.ProductCharacteristics;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class ProductCharacteristicsRequest {

    @NotBlank @NotEmpty
    private final String name;
    @NotBlank @NotEmpty
    private final String description;

    public ProductCharacteristicsRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProductCharacteristics toEntity(Product product){
        return new ProductCharacteristics(name, description, product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCharacteristicsRequest that = (ProductCharacteristicsRequest) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
