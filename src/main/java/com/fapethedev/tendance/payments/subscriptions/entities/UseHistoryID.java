package com.fapethedev.tendance.payments.subscriptions.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * <p>The id of {@code UseHistory} entity as it's a join column
 * from functionalities and users.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Data
@Embeddable
public class UseHistoryID implements Serializable
{
    /**
     * <p>The referenced functionality id.</p>
     */
    @Column(name = "functionality_id")
    private UUID functionalityId;

    /**
     * <p>The referenced user id.</p>
     */
    @Column(name = "user_id")
    private UUID userId;
}
