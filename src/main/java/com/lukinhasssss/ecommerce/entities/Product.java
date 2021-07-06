package com.lukinhasssss.ecommerce.entities;

import com.lukinhasssss.ecommerce.dto.request.ProductCharacteristicsRequest;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

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
    private User user;

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private Set<ProductCharacteristics> characteristics = new HashSet<>();

    private Product() {}

    public Product(String name, BigDecimal value, Integer availableQuantity, String description, Category category, Set<ProductCharacteristicsRequest> productCharacteristicsRequest, User user) {
        this.name = name;
        this.value = value;
        this.availableQuantity = availableQuantity;
        this.description = description;
        this.category = category;
        productCharacteristicsRequest.forEach(request -> this.characteristics.add(request.toEntity(this)));
        this.user = user;
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

    public Set<ProductCharacteristics> getCharacteristics() {
        return characteristics;
    }
}
