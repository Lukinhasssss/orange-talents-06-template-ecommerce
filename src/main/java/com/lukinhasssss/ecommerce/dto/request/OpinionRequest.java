package com.lukinhasssss.ecommerce.dto.request;

import com.lukinhasssss.ecommerce.entities.Opinion;
import com.lukinhasssss.ecommerce.entities.Product;
import com.lukinhasssss.ecommerce.entities.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class OpinionRequest {

    @Min(1)
    private Integer note;

    @NotBlank
    private String title;

    @NotBlank @Size(max = 500)
    private String description;

    public OpinionRequest(Integer note, String title, String description) {
        this.note = note;
        this.title = title;
        this.description = description;
    }

    public Integer getNote() {
        return note;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Opinion convertToEntity(Product product, User user) {
        return new Opinion(note, title, description, product, user);
    }
}
