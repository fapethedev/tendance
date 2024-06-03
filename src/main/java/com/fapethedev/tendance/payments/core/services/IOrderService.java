package com.fapethedev.tendance.payments.core.services;


import com.fapethedev.tendance.payments.core.entities.Cart;
import com.fapethedev.tendance.payments.core.entities.Order;

import java.util.List;
import java.util.UUID;

/**
 * <p>Service layer interface for order entities.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
public interface IOrderService
{
    /**
     * <p>Validate a cart and be ready for processing to a payment.</p>
     *
     * @param cart the cart to validate
     *
     * @return a new order for the cart and the user
     */
    Order validateCart(Cart cart);

    /**
     * <p>Retrieve an order with his identifier.</p>
     *
     * @param id the order id
     *
     * @return the order if exists
     */
    default Order findById(UUID id){return null;}

    /**
     * <p>Gets all orders emits.</p>
     *
     * @return the list of orders
     */
    List<Order> findAll();

    /**
     * <p>Find an order with the identifier of the associated cart.</p>
     *
     * @param id the cart id
     *
     * @return the order if exists
     */
    default Order findByCartId(UUID id){return null;}

    /**
     * <p>Find all order for a client by use his identifier.</p>
     *
     * @param id the user id
     *
     * @return all orders for this client
     */
    default List<Order> findByClientId(UUID id){return null;}
}
