package com.ekiras.repository;

import com.ekiras.domain.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    
    Payment findByPaymentId(Long paymentId);
}
