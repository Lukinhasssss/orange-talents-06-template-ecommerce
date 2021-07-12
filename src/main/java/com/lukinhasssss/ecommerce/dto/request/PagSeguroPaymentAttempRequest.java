package com.lukinhasssss.ecommerce.dto.request;

import com.lukinhasssss.ecommerce.config.validation.CheckIfIdExists;
import com.lukinhasssss.ecommerce.entities.PaymentAttempt;
import com.lukinhasssss.ecommerce.entities.Purchase;
import com.lukinhasssss.ecommerce.entities.enums.TransactionStatus;
import com.lukinhasssss.ecommerce.repositories.PurchaseRepository;

import javax.validation.constraints.NotNull;

public class PagSeguroPaymentAttempRequest {

    @NotNull
    @CheckIfIdExists(domainClass = Purchase.class, fieldName = "id", message = "Não existe compra com este ID")
    private Long purchaseId;

    @NotNull
    private String transactionId;

    @NotNull
    private TransactionStatus status;

    public PagSeguroPaymentAttempRequest() {
    }

    public PagSeguroPaymentAttempRequest(Long purchaseId, String transactionId, TransactionStatus status) {
        this.purchaseId = purchaseId;
        this.transactionId = transactionId;
        this.status = status;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public PaymentAttempt convert(PurchaseRepository purchaseRepository) {
        Purchase purchase = purchaseRepository.findById(purchaseId).get();
        return new PaymentAttempt(transactionId, purchase, status);
    }

}
