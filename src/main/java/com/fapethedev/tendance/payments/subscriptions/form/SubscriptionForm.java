package com.fapethedev.tendance.payments.subscriptions.form;

import com.fapethedev.tendance.main.constants.CurrencyCode;
import com.fapethedev.tendance.payments.subscriptions.entities.SubscriptionPlan;
import com.fapethedev.tendance.users.entities.User;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>The subscription form representation.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Data
@Builder
public class SubscriptionForm
{
    /**
     * <p>The date and time which the subscription is subject to start.
     * This value should be a present datetime or a future datetime.</p>
     */
    @FutureOrPresent
    private LocalDateTime endDateTime;

    /**
     * <p>The date and time which the subscription is subject to end.
     * This value should be a present datetime or a future datetime.</p>
     */
    @FutureOrPresent
    private LocalDateTime startDateTime;

    /**
     * <p>The total cost of the subscription.</p>
     */
    @Positive
    private Double cost;

    /**
     * <p>The total duration of the subscription.</p>
     */
    @Positive
    private Integer duration;

    /**
     * <p>The currency code of the subscription cost.</p>
     */
    private CurrencyCode currency;

    /**
     * <p>The user that subscribes, his value shouldn't be null.</p>
     */
    @NotNull
    private User subscriber;

    /**
     * <p>The plan that the user subscribes.Null value is not allow for this field.</p>
     */
    @NotNull
    private SubscriptionPlan plan;
}
