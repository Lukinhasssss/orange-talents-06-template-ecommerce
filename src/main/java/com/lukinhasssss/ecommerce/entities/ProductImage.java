package com.lukinhasssss.ecommerce.entities;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_image")
public class ProductImage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @URL
    @Column(nullable = false)
    private String url;

    @NotNull
    @ManyToOne(optional = false)
    private Product product;

    @Deprecated
    public ProductImage() {}

    public ProductImage(String url, Product product) {
        this.url = url;
        this.product = product;
    }

}
