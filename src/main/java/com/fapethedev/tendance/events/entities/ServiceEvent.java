package com.fapethedev.tendance.events.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import com.fapethedev.tendance.users.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Event service entity created by user with type {@link User.UserType} Service Provider
 * @author Fapethedev
 * @since 1.0
 */
@Entity
@Table(name = "services")
@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class ServiceEvent extends BaseEntity<UUID>
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
     * The user owning the service
     */
    @JoinColumn
    @ManyToOne
    private User user;
}
