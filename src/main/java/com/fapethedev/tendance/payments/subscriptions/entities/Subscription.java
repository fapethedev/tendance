package com.fapethedev.tendance.payments.subscriptions.entities;

import com.fapethedev.tendance.main.constants.CurrencyCode;
import com.fapethedev.tendance.main.entities.BaseEntity;
import com.fapethedev.tendance.users.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <p>The subscription of a user to a subscription plan.
 * When a user creates a new account he automatically
 * subscription to the standard subscription
 * </p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "subscriptions")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Subscription extends BaseEntity<UUID>
{
    /**
     * <p>The date with the time which the subscription will start.</p>
     */
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime startDateTime;

    /**
     * <p>The date with the time which the subscription will end.</p>
     */
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime endDateTime;

    /**
     * <p>The cost of the subscription, it will be calculate basis on the
     * duration and the plan price.</p>
     */
    @Column(nullable = false)
    private Double cost;

    /**
     * <p>The value of the subscription duration in day or month or year.</p>
     */
    @Column(nullable = false)
    private Integer duration;

    /**
     * <p>The currency used by the user.</p>
     */
    @Column(nullable = false)
    private CurrencyCode currency;

    /**
     * <p>The user that subscribes to a plan.</p>
     */
    @JoinColumn(
            name = "user_id",
            nullable = false,
            updatable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_subscriptions_users_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User subscriber;

    /**
     * <p>The plan which is the object of the subscription.</p>
     */
    @JoinColumn(
            name = "plan_id",
            nullable = false,
            updatable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_subscriptions_subscriptions_plan_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private SubscriptionPlan plan;
}
