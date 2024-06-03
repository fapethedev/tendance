package com.fapethedev.tendance.payments.core.entities;


import com.fapethedev.tendance.main.entities.BaseEntity;
import com.fapethedev.tendance.users.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * <p>The order entity that's will conduct the user
 * to the payement.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "orders")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Order extends BaseEntity<UUID>
{
    /**
     * <p>The total amount ot the order resulting
     * from validating the cart.</p>
     */
    @Column(name = "total_cost", nullable = false)
    private Double totalCost;

    /**
     * <p>The cart that is validated.</p>
     */
    @JoinColumn(
            name = "cart_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_orders_carts_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Cart cart;

    /**
     * <p>The user that's validate the cart.</p>
     */
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_orders_users_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User client;
}
