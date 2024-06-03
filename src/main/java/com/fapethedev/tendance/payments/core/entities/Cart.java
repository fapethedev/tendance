package com.fapethedev.tendance.payments.core.entities;

import com.fapethedev.tendance.main.constants.CurrencyCode;
import com.fapethedev.tendance.main.entities.BaseEntity;
import com.fapethedev.tendance.users.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>The entity that represent the cart itself in the database.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "carts")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Cart extends BaseEntity<UUID>
{
    /**
     * <p>Whether the cart is validated meaning a future order or not.</p>
     */
    @Column(nullable = false)
    private boolean isValidated;

    /**
     * <p>The code of the currency used for the items in the cart.</p>
     */
    @Column(
            name = "currency_code",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private CurrencyCode currency;

    /**
     * <p>The list of all the items inside the cart.</p>
     */
    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CartItem> items = new ArrayList<>();

    /**
     * <p>Get to value of the cart by summing all the cart item price.</p>
     *
     * @return the price of all items
     */
    @Column(name = "total_price")
    public double getTotalPrice()
    {
        return items.stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
    }

    /**
     * <p>The user that's owns the cart</p>
     */
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_carts_users_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private User owner;

    /**
     * <p>Add an item to the cart.</p>
     *
     * @param item the item to add
     */
    public void addItem(CartItem item)
    {
        items.add(item);
        item.setCart(this);
    }

    /**
     * <p>Remove a cart item from the cart.</p>
     *
     * @param item the cart item to remove
     */
    public void removeItem(CartItem item)
    {
        items.remove(item);
        item.setCart(null);
    }

}
