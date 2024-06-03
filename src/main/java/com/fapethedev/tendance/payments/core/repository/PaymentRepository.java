package com.fapethedev.tendance.payments.core.repository;

import com.fapethedev.tendance.payments.core.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * <p>Payment database layer interface.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}