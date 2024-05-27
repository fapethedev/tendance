package com.fapethedev.tendance.events.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import com.fapethedev.tendance.users.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn
    @ManyToOne
    private Event event;

    /**
     * The service which is concerned by the prestation
     */
    @JoinColumn
    @ManyToOne
    private Delivery delivery;

    /**
     * The user that create the {@code Delivery}
     * which will be the object of the prestation
     */
    @JoinColumn(
            nullable = false,
            name = "event_user_id",
            referencedColumnName = "id"
    )
    @ManyToOne
    private User eventUser;

    /**
     * The user that create the {@code Delivery}
     * which will be the object of the prestation
     */
    @JoinColumn(
            nullable = false,
            name = "delivery_user_id",
            referencedColumnName = "id"
    )
    @ManyToOne
    private User deliveryUser;
}
