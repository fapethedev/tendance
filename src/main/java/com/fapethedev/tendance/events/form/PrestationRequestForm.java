package com.fapethedev.tendance.events.form;

import com.fapethedev.tendance.events.entities.Delivery;
import com.fapethedev.tendance.events.entities.Event;
import com.fapethedev.tendance.events.entities.PrestationRequestStatus;
import com.fapethedev.tendance.users.entities.User;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

/**
 * <p>The form which user can fill to made a {@code PrestationRequest}.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Data
@Builder
public class PrestationRequestForm
{
    /**
     * <p>The message that accompany the request/p>
     */
    @Length(min = 8)
    @NotBlank
    @NotNull
    private String message;

    /**
     * <p>The status of the request.
     * By default it's pending means it's a fresh request.</p>
     */
    @Null
    private PrestationRequestStatus status;

    /**
     * <p>The start of the prestation linked to the request.</p>
     */
    @NotNull
    @FutureOrPresent
    private LocalDateTime startDateTime;

    /**
     * <p>The ene of the prestation linked to the request.</p>
     */
    @NotNull
    @FutureOrPresent
    private LocalDateTime endDateTime;

    /**
     * <p>The service which is concerned.</p>
     */
    @NotNull
    private Delivery delivery;

    /**
     * <p>The event where the prestation is likely to be performed.</p>
     */
    @NotNull
    private Event event;

    /**
     * <p>The user that send the request.</p>
     */
    @NotNull
    private User sender;

    /**
     * <p>The user that the request will be sent</p>
     */
    @NotNull
    private User receiver;
}
