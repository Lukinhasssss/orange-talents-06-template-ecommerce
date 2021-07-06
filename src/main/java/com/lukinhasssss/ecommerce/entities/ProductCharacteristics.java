package com.lukinhasssss.ecommerce.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_characteristics")
public class ProductCharacteristics {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @NotNull
    @ManyToOne()
    private Product product;

    @Deprecated
    public ProductCharacteristics() {}

    public ProductCharacteristics(String name, String description, Product product) {
        this.name = name;
        this.description = description;
        this.product = product;
    }

}
