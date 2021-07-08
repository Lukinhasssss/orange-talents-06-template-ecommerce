package com.lukinhasssss.ecommerce.dto.response;

import com.lukinhasssss.ecommerce.entities.Question;

public class QuestionResponse {

    private String title;

    public QuestionResponse(Question question) {
        this.title = question.getTitle();
    }

    public String getTitle() {
        return title;
    }
}
