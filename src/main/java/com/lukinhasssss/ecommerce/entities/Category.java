package com.lukinhasssss.ecommerce.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_category")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private Category motherCategory;

    @Deprecated
    public Category() {}

    public Category(String name, Category motherCategory) {
        this.name = name;
        this.motherCategory = motherCategory;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getMotherCategory() {
        return motherCategory;
    }

}
