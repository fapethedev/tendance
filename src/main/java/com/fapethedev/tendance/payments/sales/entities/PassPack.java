package com.fapethedev.tendance.payments.sales.entities;

import jakarta.persistence.*;
import lombok.*;

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
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class PassPack extends Pass
{
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
