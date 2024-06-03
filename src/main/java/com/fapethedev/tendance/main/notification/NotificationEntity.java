package com.fapethedev.tendance.main.notification;

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
 * <p>Entity class for notifications.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "notifications")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class NotificationEntity extends BaseEntity<UUID>
{
    /**
     * <p>The notification message.</p>
     */
    @Column(name = "message", nullable = false)
    private String message;

    /**
     * <p>The user which observes the notification.</p>
     */
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = true,
            foreignKey = @ForeignKey(name = "FK_notifications_users_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private User receiver;

    /**
     * <p>The instant of notification.</p>
     */
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime timestamp;
}
