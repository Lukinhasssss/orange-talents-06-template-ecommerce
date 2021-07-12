package com.lukinhasssss.ecommerce.controllers;

import com.lukinhasssss.ecommerce.dto.request.PagSeguroPaymentAttempRequest;
import com.lukinhasssss.ecommerce.dto.request.PayPalPaymentAttemptRequest;
import com.lukinhasssss.ecommerce.entities.PaymentAttempt;
import com.lukinhasssss.ecommerce.entities.User;
import com.lukinhasssss.ecommerce.entities.enums.TransactionStatus;
import com.lukinhasssss.ecommerce.repositories.PaymentAttemptRepository;
import com.lukinhasssss.ecommerce.repositories.PurchaseRepository;
import com.lukinhasssss.ecommerce.utils.email.SendEmailFake;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping
public class ProcessPaymentController {

    private PaymentAttemptRepository paymentAttemptRepository;
    private PurchaseRepository purchaseRepository;
    private SendEmailFake sendEmailFake;

    public ProcessPaymentController(PaymentAttemptRepository paymentAttemptRepository, PurchaseRepository purchaseRepository, SendEmailFake sendEmailFake) {
        this.paymentAttemptRepository = paymentAttemptRepository;
        this.purchaseRepository = purchaseRepository;
        this.sendEmailFake = sendEmailFake;
    }

    @GetMapping("pagseguro-payment")
    public ResponseEntity<?> paymentWithPagSeguro(@Valid PagSeguroPaymentAttempRequest request, @AuthenticationPrincipal User user){
        PaymentAttempt paymentAttempt = request.convert(purchaseRepository);
        paymentAttemptRepository.save(paymentAttempt);

        String message = "Purchase fail";
        if(paymentAttempt.getStatus() == TransactionStatus.SUCCESS){
            message = "Purchase with success";
            sendRequestToThirdPartyServices(user, paymentAttempt);
        }
        sendEmailFake.sendEmail(message);
        return ResponseEntity.ok(paymentAttempt);
    }

    @GetMapping("paypal-payment")
    public ResponseEntity<?> paymentWithPayPal(@Valid PayPalPaymentAttemptRequest request, @AuthenticationPrincipal User user){
        PaymentAttempt paymentAttempt = request.convert(purchaseRepository);
        paymentAttemptRepository.save(paymentAttempt);

        String message = "Purchase fail";
        if(paymentAttempt.getStatus() == TransactionStatus.SUCCESS){
            message = "Purchase with success";
            sendRequestToThirdPartyServices(user, paymentAttempt);
        }
        sendEmailFake.sendEmail(message);
        return ResponseEntity.ok(paymentAttempt);
    }

    private void sendRequestToThirdPartyServices(User user, PaymentAttempt paymentAttempt) {
        String urlInvoice = "https://fake-invoice.com";
        String urlSellerRank = "https://fake-seller-rank.com";

        RestTemplate restTemplate = new RestTemplate();


        LinkedMultiValueMap bodyInvoice = new LinkedMultiValueMap();
        bodyInvoice.add("purchase", paymentAttempt.getPurchase().getId());
        bodyInvoice.add("user", user.getId());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity httpEntityInvoice = new HttpEntity(bodyInvoice,headers);
        HttpEntity httpEntitySellerRank = new HttpEntity(bodyInvoice,headers);


        try {
            restTemplate.exchange(urlInvoice, HttpMethod.POST, httpEntityInvoice, String.class);
            restTemplate.exchange(urlSellerRank, HttpMethod.POST, httpEntitySellerRank, String.class);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
