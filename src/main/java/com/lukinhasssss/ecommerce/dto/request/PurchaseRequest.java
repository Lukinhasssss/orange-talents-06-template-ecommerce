package com.lukinhasssss.ecommerce.dto.request;

import com.lukinhasssss.ecommerce.config.validation.CheckIfIdExists;
import com.lukinhasssss.ecommerce.entities.Product;
import com.lukinhasssss.ecommerce.entities.Purchase;
import com.lukinhasssss.ecommerce.entities.User;
import com.lukinhasssss.ecommerce.entities.enums.PaymentGateway;
import com.lukinhasssss.ecommerce.entities.enums.PurchaseStatus;
import com.lukinhasssss.ecommerce.repositories.ProductRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PurchaseRequest {

    @NotNull @Positive
    private Integer quantity;

    @NotNull
    private PaymentGateway paymentGateway;

    private PurchaseStatus status = PurchaseStatus.STARTED;

    @NotNull
    @CheckIfIdExists(domainClass = Product.class, fieldName = "id", message = "Não existe produto com o id escolhido")
    private Long productId;

    public PurchaseRequest() {}

    public PurchaseRequest(Integer quantity, PaymentGateway paymentGateway, Long productId) {
        this.quantity = quantity;
        this.paymentGateway = paymentGateway;
        this.productId = productId;
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

    public Long getProductId() {
        return productId;
    }

    public Purchase convertToEntity(ProductRepository productRepository, User user) {
        Product product = productRepository.getById(productId);

        return new Purchase(quantity, paymentGateway, status, product, user);
    }
}
