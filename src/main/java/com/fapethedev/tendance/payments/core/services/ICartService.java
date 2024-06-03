package com.fapethedev.tendance.payments.core.services;

import com.fapethedev.tendance.payments.core.entities.Cart;
import com.fapethedev.tendance.payments.core.entities.CartItem;
import com.fapethedev.tendance.users.entities.User;

/**
 * <p>Service layer interface for cart entity.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
public interface ICartService
{
    /**
     * <p>Creates an empty cart for a user.</p>
     *
     * @param user the owner of the cart
     *
     * @return a cart for the user
     */
    Cart createCart(User user);

    /**
     * <p>Add element to the cart.</p>
     *
     * @param cart the cart
     *
     * @param item the cart item
     */
    void addItemToCart(Cart cart, CartItem item);

    /**
     * <p>Remove an element from the cart.</p>
     *
     * @param cart the cart
     *
     * @param item the cart item
     */
    void removeItemFromCart(Cart cart, CartItem item);

    /**
     * <p>Get the total amount of item cost in the cart.</p>
     *
     * @param cart the user cart
     *
     * @return the total amount of the cart
     */
    double getTotalPrice(Cart cart);
}
