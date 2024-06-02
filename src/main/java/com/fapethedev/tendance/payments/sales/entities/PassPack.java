package com.fapethedev.tendance.payments.sales.entities;

import com.fapethedev.tendance.events.entities.Event;
import com.fapethedev.tendance.main.constants.CurrencyCode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * <p>The pack of tickets entity. Represents
 * a set of tickets that is grouped.</p>
 *
 * @see com.fapethedev.tendance.main.entities.BaseEntity
 * @see com.fapethedev.tendance.payments.sales.entities.Pass
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "packs")
@Getter @Setter
@NoArgsConstructor
public class PassPack extends Pass
{
    public PassPack(String logo, Double price, CurrencyCode currency, Integer stock, PassState passState, PassType passType, Event event, List<Pass> passes) {
        super(logo, price, currency, stock, passState, passType, event);
        this.passes = passes;
    }

    /**
     * <p>The list of all passes that the pack contain.</p>
     */
    @JoinTable(
            name = "packs_on_tickets",
            joinColumns = @JoinColumn(
                    name = "pack_id",
                    referencedColumnName = "id",
                    table = "packs"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "ticket_id",
                    referencedColumnName = "id",
                    table = "tickets"
            ),
            foreignKey = @ForeignKey(
                    name = "FK_packs_on_tickets_packs_id"
            ),
            inverseForeignKey = @ForeignKey(
                    name = "FK_packs_on_tickets_tickets_id"
            )
    )
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Pass> passes;
}
