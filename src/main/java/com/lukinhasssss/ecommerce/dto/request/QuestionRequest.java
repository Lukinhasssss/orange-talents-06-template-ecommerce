package com.lukinhasssss.ecommerce.dto.request;

import com.lukinhasssss.ecommerce.entities.Product;
import com.lukinhasssss.ecommerce.entities.Question;
import com.lukinhasssss.ecommerce.entities.User;

import javax.validation.constraints.NotBlank;

public class QuestionRequest {

    @NotBlank
    private String title;

    public String getTitle() {
        return title;
    }


    public Question convertToEntity(Product product, User user) {
        return new Question(title, product, user);
    }
}
