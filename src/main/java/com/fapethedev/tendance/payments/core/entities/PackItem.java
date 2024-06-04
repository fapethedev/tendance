package com.fapethedev.tendance.payments.core.entities;


import com.fapethedev.tendance.payments.sales.entities.PassPack;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>The pack item is a cart item linked with a ticket</p>
 *
 * @see CartItem
 * @see com.fapethedev.tendance.payments.core.entities.SubscriptionPlanItem
 * @see com.fapethedev.tendance.payments.core.entities.TicketItem
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Entity
@DiscriminatorValue("pack")
@Getter @Setter
public class PackItem extends CartItem
{
    /**
     * <p>The associated element as the PackItem
     * is a wrapper class for pack as a cart item.</p>
     */
    @JoinColumn(
            name = "pack_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_cart_items_packs_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private PassPack pack;

    /**
     * <p>No arg constructor matching super.
     * A specialized item still an abstract impl.</p>
     */
    public PackItem() {
        super();
    }

    /**
     * <p>Constructor matching super with the associated pack</p>
     *
     * @param quantity the item quantity in the cart
     * @param cart the cart object
     * @param pack the pack in the cart item
     */
    public PackItem(Integer quantity, Cart cart, PassPack pack) {
        super(quantity, cart);
        this.pack = pack;
    }

    /**
     * <p>Evaluated the price with the pack item price.</p>
     *
     * @return the price of the pack in the cart following his quantity
     */
    @Override
    public double getPrice()
    {
        return pack.getPrice() * quantity;
    }

}
