package com.fapethedev.tendance.payments.subscriptions.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * <p>A subscription to use a couple of features always refers
 * to a {@code SubscriptionPlan}.
 * This is the entity that's represents à subscription plan.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "subscription_plans")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class SubscriptionPlan extends BaseEntity<UUID>
{
    /**
     * <p>The title of the subscription, it can be use as the name of the plan.</p>
     */
    @Column(
            nullable = false,
            unique = true
    )
    private String title;

    /**
     * <p>The content of the plan.Like functionality list and more.</p>
     */
    @Column(nullable = false,
            length = 4096,
            columnDefinition = "TEXT"
    )
    private String content;

    /**
     * <p>Defines the price of a subscription to this plan.</p>
     */
    @Column(nullable = false)
    private Double price;

    /**
     * <p>A plan can be not available so no it's won't be display and
     * no future subscription to this plan will possible.</p>
     */
    @Column(nullable = false)
    private Boolean isAvailable;
}
