package com.lukinhasssss.ecommerce.controllers;

import com.lukinhasssss.ecommerce.dto.request.PurchaseRequest;
import com.lukinhasssss.ecommerce.entities.Product;
import com.lukinhasssss.ecommerce.entities.Purchase;
import com.lukinhasssss.ecommerce.entities.User;
import com.lukinhasssss.ecommerce.repositories.ProductRepository;
import com.lukinhasssss.ecommerce.repositories.PurchaseRepository;
import com.lukinhasssss.ecommerce.utils.email.SendEmailFake;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private ProductRepository productRepository;
    private PurchaseRepository purchaseRepository;
    private SendEmailFake sendEmailFake;

    public PurchaseController(ProductRepository productRepository, PurchaseRepository purchaseRepository, SendEmailFake sendEmailFake) {
        this.productRepository = productRepository;
        this.purchaseRepository = purchaseRepository;
        this.sendEmailFake = sendEmailFake;
    }

    @PostMapping
    public ResponseEntity<String> purchase(@RequestBody @Valid PurchaseRequest request, @AuthenticationPrincipal User user) {
        Product product = productRepository.findById(request.getProductId()).get();

        if (product.canShotDownPurchase(request.getQuantity())) {
            productRepository.save(product);

            Purchase purchase = request.convertToEntity(productRepository, user);
            purchaseRepository.save(purchase);

            sendEmailFake.sendEmail("Email send to " + user.getLogin());
            return ResponseEntity.status(HttpStatus.FOUND).body(purchase.getPaymentGateway().getUrl(purchase.getId()));
        }

        return ResponseEntity.badRequest().body("O produto " + product.getName() + " não tem quantidade suficiente");
    }

}
