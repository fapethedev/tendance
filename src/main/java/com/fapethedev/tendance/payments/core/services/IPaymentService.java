package com.fapethedev.tendance.payments.core.services;

import com.fapethedev.tendance.payments.core.entities.Order;
import com.fapethedev.tendance.payments.core.entities.Payment;

import java.util.List;
import java.util.UUID;

/**
 * <p>Service layer class for payements.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
public interface IPaymentService
{
    /**
     * <p>Confirm an order and generates a payment.</p>
     *
     * @param order the order
     *
     * @return the payment
     */
    Payment confirmPayment(Order order);

    /**
     * <p>Find a payment with his id.</p>
     *
     * @param id the payment id
     *
     * @return the payment if exist
     */
    default Payment findById(UUID id){return null;}

    /**
     * <p>Find all payment that's have been made.</p>
     *
     * @return the list of all payments
     */
    List<Payment> findAll();

    /**
     * <p>Find a payment with the order that's was confirmed.</p>
     *
     * @param id the order id
     *
     * @return the payement if it was made
     */
    default Payment findByOrderId(UUID id){return null;}

    /**
     * <p>Find all the payments made by a user.</p>
     *
     * @param id the user id
     *
     * @return the list of all payments for this client
     */
    default List<Payment> findByClientId(UUID id){return null;}
}
