package com.lukinhasssss.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lukinhasssss.ecommerce.entities.enums.TransactionStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(name = "tb_payment_attempt")
public class PaymentAttempt {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String transactionId;

    @NotNull
    @ManyToOne
    @JsonIgnore
    private Purchase purchase;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private Instant createdAt = Instant.now();

    @Deprecated
    public PaymentAttempt() {}

    public PaymentAttempt(String transactionId, Purchase purchase, TransactionStatus status) {
        this.transactionId = transactionId;
        this.purchase = purchase;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
