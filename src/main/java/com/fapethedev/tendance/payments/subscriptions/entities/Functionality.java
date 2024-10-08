package com.fapethedev.tendance.payments.subscriptions.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * <p>The entity that's represent a functionality.
 * Functionalities are use to implements the requirement
 * of subscription to use some app features.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "functionalities")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Functionality extends BaseEntity<UUID>
{
    /**
     * <p>The name of the functionality.
     * It's a mandatory and not subject to update.</p>
     */
    @Column(
            nullable = false,
            unique = true,
            updatable = false
    )
    private String designation;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    /**
     * <p>The nature of the functionalities.</p>
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FunctionalityType type;
}
