package com.fapethedev.tendance.settings.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import com.fapethedev.tendance.users.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * <p>UI Appearance entities.
 * Has the role to assure a constant and mutable
 * ui appearance through the application and user ui configuration.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "appearances")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Appearance extends BaseEntity<UUID>
{
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Theme theme;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Direction direction;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Layout layout;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sizing sizing;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Border border;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Card card;

    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
