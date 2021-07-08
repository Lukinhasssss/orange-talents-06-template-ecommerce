package com.lukinhasssss.ecommerce.dto.response;

import com.lukinhasssss.ecommerce.entities.ProductCharacteristics;

public class CharacteristicsResponse {

    private String name;
    private String description;

    public CharacteristicsResponse(ProductCharacteristics characteristics) {
        this.name = characteristics.getName();
        this.description = characteristics.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
