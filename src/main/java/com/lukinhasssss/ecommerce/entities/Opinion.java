package com.lukinhasssss.ecommerce.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_opinion")
public class Opinion {

    @Id @GeneratedValue
    private Long id;

    private Integer note;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;

    @Deprecated
    public Opinion() {}

    public Opinion(Integer note, String title, String description, Product product, User user) {
        this.note = note;
        this.title = title;
        this.description = description;
        this.product = product;
        this.user = user;
    }

    public Long getId() {
        return id;
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

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }
}
