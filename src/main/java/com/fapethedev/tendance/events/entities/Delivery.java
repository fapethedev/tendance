package com.fapethedev.tendance.events.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import com.fapethedev.tendance.users.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

/**
 * <p>Representation of service prestation or sponsoring service.
 * User like service provider or sponsor are concerned.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "deliveries")
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Delivery extends BaseEntity<UUID>
{
    /**
     * The service name
     */
    @Column(nullable = false)
    private String name;

    /**
     * The description of the service
     */
    @Column(nullable = false)
    private String description;

    /**
     * The service cost
     */
    @Column(nullable = false)
    private Double price;

    /**
     * The currency use by the service provider
     */
    @Column(nullable = false)
    private String currency;

    /**
     * <p>The poster is like the picturesque representation of the service.</p>
     */
    @Column(nullable = true)
    private String poster;

    /**
     * <p>The user that's creates the delivery.</p>
     */
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    /**
     * <p>All prestations where this delivery feature.</p>
     */
    @JoinColumn
    @OneToMany(fetch = FetchType.LAZY)
    private List<Prestation> prestations;
}
