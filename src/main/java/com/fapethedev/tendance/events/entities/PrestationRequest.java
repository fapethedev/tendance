package com.fapethedev.tendance.events.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import com.fapethedev.tendance.users.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <p>A in app request for a service or a sponsor
 * for featuring in a particular event.
 * Both concerned users the sender and the receiver shouldn't be
 * of type admin, standard or visitor.</p>
 * <p>The request is bidirectional so a service provider can
 * send a request to an organizer and vice versa.It's important
 * to notice that the request should always about an event and a service
 * what means user of the same type can't send request between them.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "prestation_requests")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class PrestationRequest extends BaseEntity<UUID>
{
    /**
     * <p>The engage message which will be serve for the notification
     * or something like this.</p>
     */
    @Column(nullable = false)
    private String message;

    /**
     * <p>The status of this prestation request.</p>
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PrestationRequestStatus status;

    /**
     * <p>The date and time which the concerned service should start
     * featuring.
     * This value can't below the start date of the event nor after
     * the end date of the event.</p>
     */
    @Column(nullable = false)
    private LocalDateTime startDateTime;

    /**
     * <p>The date and time which the concerned service should end.
     * This value can't below the start date of the prestation and the event nor after
     * the end date of the event.</p>
     */
    @Column(nullable = false)
    private LocalDateTime endDateTime;

    /**
     * <p>The delivery which is a about the prestation.</p>
     */
    @Column(nullable = false)
    @ManyToOne
    private Delivery delivery;

    /**
     * <p>The event which the desired prestation is aim to feature.</p>
     */
    @JoinColumn(nullable = false)
    @ManyToOne
    private Event event;

    /**
     * <p>The user that send the request. He can be a service provider
     * or a sponsor or an event organizer.</p>
     */
    @JoinColumn(
            nullable = false,
            name = "sender_id",
            referencedColumnName = "id"
    )
    @ManyToOne
    private User sender;

    /**
     * <p>The user that receive the request. He can be a service provider
     * or a sponsor or an event organizer.</p>
     */
    @JoinColumn(
            nullable = false,
            name = "receiver_id",
            referencedColumnName = "id"
    )
    @ManyToOne
    private User receiver;
}
