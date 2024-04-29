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
 */
@Entity
@Table(name = "prestations")
@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class Prestation extends BaseEntity<UUID>
{
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
     * The user that create the {@code ServiceEvent}
     * which will be the object of the prestation
     */
    @JoinColumn
    @ManyToOne
    private User user;

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
    private ServiceEvent serviceEvent;
}
