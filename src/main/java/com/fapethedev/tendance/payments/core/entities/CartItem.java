package com.fapethedev.tendance.payments.core.entities;


import com.fapethedev.tendance.main.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * <p>The cart item is the representation of an element in the cart.
 * It's has a link with the cart and also a quantity that's help to determine
 * the item price in the cart.</p>
 * <p>There is many subclasses as there is different kind of item.</p>
 *
 * @see com.fapethedev.tendance.main.entities.BaseEntity
 *
 * @see TicketItem
 * @see PackItem
 * @see SubscriptionPlanItem
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "cart_items")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public abstract class CartItem extends BaseEntity<UUID>
{
    /**
     * <p>The quantity of the item in the cart.</p>
     */
    @Column(
            name = "quantity",
            nullable = false
    )
    protected Integer quantity;

    /**
     * <p>The associated cart which the item is.</p>
     */
    @JoinColumn(
            name = "cart_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_cart_items_carts_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    protected Cart cart;

    /**
     * <p>Get the price of a cart item following the nature of the
     * item and his quantity in the cart.</p>
     *
     * @return the value the item quantity in the cart
     */
    public abstract double getPrice();
}
