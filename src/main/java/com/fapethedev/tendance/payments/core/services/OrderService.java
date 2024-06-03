package com.fapethedev.tendance.payments.core.services;

import com.fapethedev.tendance.payments.core.entities.Cart;
import com.fapethedev.tendance.payments.core.entities.Order;
import com.fapethedev.tendance.payments.core.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Service class for orders entities.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements IOrderService
{
    /**
     * <p>Database layer for orders.</p>
     */
    private OrderRepository orderRepository;

    @Override
    public Order validateCart(Cart cart) {
        return orderRepository.save(
                Order.builder()
                        .totalCost(cart.getTotalPrice())
                        .currency(cart.getCurrency())
                        .client(cart.getOwner())
                        .cart(cart)
                        .build()
        );
    }

    @Override
    public List<Order> findAll()
    {
        return orderRepository.findAll();
    }

}
