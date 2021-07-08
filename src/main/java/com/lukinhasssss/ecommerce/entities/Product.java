package com.lukinhasssss.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lukinhasssss.ecommerce.dto.request.ProductCharacteristicsRequest;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private Integer availableQuantity;

    @Column(nullable = false)
    private String description;

    private Instant createdAt = Instant.now();

    @ManyToOne
    private Category category;

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<ProductCharacteristics> characteristics = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, fetch = FetchType.EAGER) // Quando atualizar o produto também vai atualizar as imagens
    private Set<ProductImage> images = new HashSet<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<Opinion> opinions = new HashSet<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<Question> questions = new HashSet<>();

    @Deprecated
    public Product() {}

    public Product(String name, BigDecimal value, Integer availableQuantity, String description, Category category, Set<ProductCharacteristicsRequest> productCharacteristicsRequest, User owner) {
        this.name = name;
        this.value = value;
        this.availableQuantity = availableQuantity;
        this.description = description;
        this.category = category;
        productCharacteristicsRequest.forEach(request -> this.characteristics.add(request.toEntity(this)));
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Category getCategory() {
        return category;
    }

    public User getOwner() {
        return owner;
    }

    public Set<ProductCharacteristics> getCharacteristics() {
        return characteristics;
    }

    public Set<ProductImage> getImages() {
        return images;
    }

    public Set<Opinion> getOpinions() {
        return opinions;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public Integer getTotalOpinions() {
        return this.opinions.size();
    }

    public Double getAverageNotes() {
        Integer sumOfAllNotes = this.opinions.stream().map(Opinion::getNote).mapToInt(i -> i).sum();
        return (double) (sumOfAllNotes / this.getTotalOpinions());
    }

    public boolean isUserOwner(User user) {
        return user.getId().equals(owner.getId());
    }

    public void addImages(Set<String> links) {
        this.images.addAll(links.stream().map(link -> new ProductImage(link, this)).collect(Collectors.toSet()));
    }

    public <T> Set<T> mapImages(Function<ProductImage, T> mapFunction){
        return this.images.stream().map(mapFunction).collect(Collectors.toSet());
    }
}
