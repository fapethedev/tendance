package com.fapethedev.tendance.payments.core.entities;


import com.fapethedev.tendance.payments.sales.entities.Pass;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>The ticket pass element as a cart item.</p>
 *
 * @see CartItem
 * @see PackItem
 * @see SubscriptionPlanItem
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Entity
@DiscriminatorValue("ticket")
@Getter @Setter
@NoArgsConstructor
public class TicketItem extends CartItem
{
    /**
     * <p>The ticket pass element in the cart item.</p>
     */
    @JoinColumn(
            name = "pass_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_cart_items_tickets_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Pass ticket;

    /**
     * <p>The constructor with the cart, the ticket quantity and the pass.</p>
     *
     * @param quantity the item quantity in the cart
     * @param cart the cart object
     * @param ticket the pass in the item
     */
    public TicketItem(Integer quantity, Cart cart, Pass ticket) {
        super(quantity, cart);
        this.ticket = ticket;
    }

    /**
     * <p>Return the ticket item price.</p>
     *
     * @return the total price of the item with the given quantity
     */
    @Override
    public double getPrice()
    {
        return ticket.getPrice() * quantity;
    }
}
