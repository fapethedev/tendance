package com.fapethedev.tendance.events.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import com.fapethedev.tendance.users.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Service prestation at an event entity <br/>
 * Used to keep trace of Service Provider activities
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "prestations")
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Prestation extends BaseEntity<UUID>
{
    /**
     * (Optional) the description of the prestations
     */
    @Column(nullable = true)
    private String description;

    /**
     * The date and the time which the prestation will be start received
     */
    @Column(nullable = false)
    private LocalDateTime startDateTime;

    /**
     * The date and the time which the prestation will be ended
     */
    @Column(nullable = false)
    private LocalDateTime endDateTime;

    /**
     * The event where the prestation will occur
     */
    @JoinColumn(
            nullable = false,
            name = "event_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_prestations_events_id")
    )
    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    /**
     * The service which is concerned by the prestation
     */
    @JoinColumn(
            nullable = false,
            name = "delivery_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_prestations_deliveries_id")
    )
    @ManyToOne(fetch = FetchType.LAZY)
    private Delivery delivery;

    /**
     * The user that create the {@code Delivery}
     * which will be the object of the prestation
     */
    @JoinColumn(
            nullable = false,
            name = "event_user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_prestations_users_event_user_id")
    )
    @ManyToOne(fetch = FetchType.LAZY)
    private User eventUser;

    /**
     * The user that create the {@code Delivery}
     * which will be the object of the prestation
     */
    @JoinColumn(
            nullable = false,
            name = "delivery_user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_prestations_users_delivery_user_id")
    )
    @ManyToOne(fetch = FetchType.LAZY)
    private User deliveryUser;
}
