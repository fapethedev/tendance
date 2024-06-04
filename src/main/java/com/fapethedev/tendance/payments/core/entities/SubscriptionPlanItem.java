package com.fapethedev.tendance.payments.core.entities;


import com.fapethedev.tendance.payments.subscriptions.entities.SubscriptionPlan;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>The wrapper of a subscription plan in a cart item.</p>
 *
 * @see CartItem
 * @see TicketItem
 * @see PackItem
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Entity
@DiscriminatorValue("subscription_plan")
@Getter @Setter
public class SubscriptionPlanItem extends CartItem
{
    /**
     * <p>The associated plan with the cart item as it wrapper.</p>
     */
    @JoinColumn(
            name = "plan_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_cart_items_subscription_plans_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private SubscriptionPlan plan;

    /**
     * <p>No arg constructor matching super.
     * A specialized item still an abstract impl.</p>
     */
    public SubscriptionPlanItem() {
        super();
    }

    /**
     * <p>The constructor matching super with the associated subscription plan.</p>
     *
     * @param quantity the item quantity in the cart
     * @param cart the cart object
     * @param plan the subscription plan
     */
    public SubscriptionPlanItem(Integer quantity, Cart cart, SubscriptionPlan plan)
    {
        super(quantity, cart);
        this.plan = plan;
    }

    /**
     * <p>The price of the item with quantity serves as duration.</p>
     *
     * @return the price of the subscription plan item
     */
    @Override
    public double getPrice()
    {
        return plan.getPrice() * quantity;
    }
}
