package com.lukinhasssss.ecommerce.repositories;

import com.lukinhasssss.ecommerce.entities.PaymentAttempt;
import com.lukinhasssss.ecommerce.entities.enums.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentAttemptRepository extends JpaRepository<PaymentAttempt, Long> {

    List<PaymentAttempt> findByTransactionIdAndStatus(String transactionId, TransactionStatus status);

}
