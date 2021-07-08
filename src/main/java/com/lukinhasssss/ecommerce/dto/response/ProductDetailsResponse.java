package com.lukinhasssss.ecommerce.dto.response;

import com.lukinhasssss.ecommerce.dto.request.QuestionRequest;
import com.lukinhasssss.ecommerce.entities.Opinion;
import com.lukinhasssss.ecommerce.entities.Product;
import com.lukinhasssss.ecommerce.entities.ProductCharacteristics;
import com.lukinhasssss.ecommerce.entities.ProductImage;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductDetailsResponse {

    private String name;
    private BigDecimal value;
    private String description;
    private Double averageNotes;
    private Integer totalOpinions;
    private Set<String> urls;
    private Set<QuestionResponse> questions;
    private Set<CharacteristicsResponse> characteristics;
    private Set<OpinionResponse> opinions;

    public ProductDetailsResponse(Product product) {
        this.name = product.getName();
        this.value = product.getValue();
        this.urls = product.mapImages(ProductImage::getUrl);
        this.characteristics = product.getCharacteristics().stream().map(CharacteristicsResponse::new).collect(Collectors.toSet());
        this.description = product.getDescription();
        this.averageNotes = product.getAverageNotes();
        this.totalOpinions = product.getTotalOpinions();
        this.opinions = product.getOpinions().stream().map(OpinionResponse::new).collect(Collectors.toSet());
        this.questions = product.getQuestions().stream().map(QuestionResponse::new).collect(Collectors.toSet());
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Set<String> getUrls() {
        return urls;
    }

    public Set<CharacteristicsResponse> getCharacteristics() {
        return characteristics;
    }

    public String getDescription() {
        return description;
    }

    public Double getAverageNotes() {
        return averageNotes;
    }

    public Integer getTotalOpinions() {
        return totalOpinions;
    }

    public Set<OpinionResponse> getOpinions() {
        return opinions;
    }

    public Set<QuestionResponse> getQuestions() {
        return questions;
    }

}
