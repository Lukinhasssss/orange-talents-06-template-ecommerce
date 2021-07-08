package com.lukinhasssss.ecommerce.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_question")
public class Question {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    private Instant createdAt = Instant.now();

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;

    @Deprecated
    public Question() {}

    public Question(String title, Product product, User user) {
        this.title = title;
        this.product = product;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }
}
