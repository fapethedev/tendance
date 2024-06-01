package com.fapethedev.tendance.payments.subscriptions.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import com.fapethedev.tendance.users.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <p>Keeps eyes on how user uses functionalities.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "functionality_use_histories")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class UseHistory extends BaseEntity<UUID>
{
    /**
     * <p>The history id composed by the user id and
     * the functionality id.</p>
     */
    @EmbeddedId
    private UseHistoryID usageHistoryID;

    /**
     * <p>The last time when the user uses this functionality.</p>
     */
    @Column(nullable = false)
    private LocalDateTime lastUse;

    @Column(
            name = "count",
            nullable = false
    )
    private Integer count;

    /**
     * <p>A functionality can be present but disabled which is
     * the case of freemium after expiration.
     * The functionality need a subscription to reactive for
     * the considered user.</p>
     */
    @Column(nullable = false)
    private Boolean isActive;

    /**
     *
     */
    @JoinColumn(
            name = "user_id",
            nullable = false,
            insertable = false,
            updatable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_functionality_use_histories_users_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    /**
     * <p>The referenced functionality which is used.</p>
     */
    @JoinColumn(
            name = "functionality_id",
            nullable = false,
            insertable = false,
            updatable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_functionality_use_histories_functionalities_id")
    )
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Functionality functionality;

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.lastUse = updatedAt;
        this.count++;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        this.lastUse = updatedAt;
        this.isActive = Boolean.TRUE;
        this.count = 1;
    }

    /**
     * <p>Get if a functionality need subscription if not by his usage histories.</p>
     *
     * @return true if the fun is used more than five time maybe a subscription id needed,
     * false otherwise
     */
    @Transient
    public boolean isSubscriptionNeeded() {
        return count >= 5;
    }
}
