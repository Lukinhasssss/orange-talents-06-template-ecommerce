package com.lukinhasssss.ecommerce.entities;

import com.lukinhasssss.ecommerce.entities.enums.PaymentGateway;
import com.lukinhasssss.ecommerce.entities.enums.PurchaseStatus;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_purchase")
public class Purchase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentGateway paymentGateway;

    @Enumerated(EnumType.STRING)
    private PurchaseStatus status = PurchaseStatus.STARTED;

    @NotNull
    @ManyToOne
    private Product product;

    @NotNull
    @ManyToOne
    private User buyer;

    @Deprecated
    public Purchase() {}

    public Purchase(Integer quantity, PaymentGateway paymentGateway, PurchaseStatus status, Product product, User buyer) {
        this.quantity = quantity;
        this.paymentGateway = paymentGateway;
        this.status = status;
        this.product = product;
        this.buyer = buyer;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public PaymentGateway getPaymentGateway() {
        return paymentGateway;
    }

    public PurchaseStatus getStatus() {
        return status;
    }

    public Product getProduct() {
        return product;
    }

    public User getBuyer() {
        return buyer;
    }

}
