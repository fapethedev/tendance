package com.fapethedev.tendance.payments.core.services;

import com.fapethedev.tendance.payments.core.entities.Cart;
import com.fapethedev.tendance.payments.core.entities.CartItem;
import com.fapethedev.tendance.payments.core.repository.CartRepository;
import com.fapethedev.tendance.users.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>Service class for carts entities.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CartService implements ICartService
{
    /**
     * <p>The database layer for carts.</p>
     */
    private CartRepository cartRepository;

    @Override
    public Cart createCart(User user)
    {
        return cartRepository.save(
                Cart.builder()
                        .owner(user)
                        .build()
        );
    }

    @Override
    public void addItemToCart(Cart cart, CartItem item)
    {
        cart.addItem(item);
        cartRepository.save(cart);
    }

    @Override
    public void removeItemFromCart(Cart cart, CartItem item)
    {
        cart.removeItem(item);
        cartRepository.save(cart);
    }

    @Override
    public double getTotalPrice(Cart cart) {
        return cart.getTotalPrice();
    }

}

