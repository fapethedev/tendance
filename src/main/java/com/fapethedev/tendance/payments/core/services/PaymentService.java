package com.fapethedev.tendance.payments.core.services;

import com.fapethedev.tendance.payments.core.entities.Order;
import com.fapethedev.tendance.payments.core.entities.Payment;
import com.fapethedev.tendance.payments.core.entities.PaymentServiceProvider;
import com.fapethedev.tendance.payments.core.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Service class for payments entities.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService implements IPaymentService
{
    /**
     * <p>The database layer for payments.</p>
     */
    private PaymentRepository paymentRepository;

    @Override
    public Payment confirmPayment(Order order) {
        return paymentRepository.save(
                Payment.builder()
                        .currency(order.getCurrency())
                        .client(order.getClient())
                        .amount(order.getTotalCost())
                        .service(PaymentServiceProvider.UNKNOWN)
                        .build()
        );
    }

    @Override
    public List<Payment> findAll()
    {
        return paymentRepository.findAll();
    }

}
