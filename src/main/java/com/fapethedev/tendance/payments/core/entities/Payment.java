package com.fapethedev.tendance.payments.core.entities;

import com.fapethedev.tendance.main.constants.CurrencyCode;
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
@Table(name = "payments")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Payment extends BaseEntity<UUID>
{
    /**
     * <p>The amount of money which is paid.</p>
     */
    @Column(
            name = "amount",
            nullable = false
    )
    private Double amount;

    /**
     * <p>The code of the currency used for the payement.</p>
     */
    @Column(
            name = "currency_code",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private CurrencyCode currency;

    /**
     * <p>The provider of service payement.</p>
     */
    @Column(
            name ="payment_service_provider",
            nullable = false,
            updatable = false
    )
    private PaymentServiceProvider service;

    /**
     * <p>The order which is paid.</p>
     */
    @JoinColumn(
            name = "order_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_payements_orders_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Order order;

    /**
     * <p>The user who pay.</p>
     */
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_payements_users_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User client;
}
