package com.lukinhasssss.ecommerce.dto.response;

import com.lukinhasssss.ecommerce.entities.Opinion;

public class OpinionResponse {

    private Integer note;
    private String title;
    private String description;

    public OpinionResponse(Opinion opinion) {
        this.note = opinion.getNote();
        this.title = opinion.getTitle();
        this.description = opinion.getDescription();
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

}
