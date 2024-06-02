package com.fapethedev.tendance.payments.sales.entities;

import com.fapethedev.tendance.events.entities.Event;
import com.fapethedev.tendance.main.constants.CurrencyCode;
import com.fapethedev.tendance.main.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * <p>The tickets entity for pass.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "tickets")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Pass extends BaseEntity<UUID>
{
    /**
     * <p>The image logo of ticket.</p>
     */
    @Column(
            name = "logo",
            nullable = true,
            unique = true
    )
    protected String logo;

    /**
     * <p>The ticket price.</p>
     */
    @Column(nullable = false)
    protected Double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected CurrencyCode currency;

    /**
     * <p>The available quantity of ticket.</p>
     */
    @Column(nullable = false)
    protected Integer stock;

    /**
     * <p>The state of the ticket.</p>
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected PassState passState;

    /**
     * <p>The type of the ticket.</p>
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected PassType passType;

    /**
     * <p>The event which is used the ticket.</p>
     */
    @JoinColumn(
            name = "event_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_tickets_events_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    protected Event event;
}
