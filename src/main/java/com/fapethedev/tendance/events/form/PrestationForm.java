package com.fapethedev.tendance.events.form;

import com.fapethedev.tendance.events.entities.Event;
import com.fapethedev.tendance.events.entities.ServiceEvent;
import com.fapethedev.tendance.users.entities.User;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * {@code PrestationForm} is the form class for
 * {@link com.fapethedev.tendance.events.entities.Prestation}
 * <br/>
 * It's the class the use when a user with type
 * {@code User.UserType.SERVICE_PROVIDER} will perform a
 * successful request for service prestation
 * @author Fapethedev
 * @since 1.0
 */
@Data
@Builder
public class PrestationForm
{
    /**
     * The start date and time which the prestation will be start to perform at
     * the event.
     * <br/>
     * This field as a {@code LocalDateTime} should be not null and a present DateTime
     * or a DataTime in the future. Past value is not allowed.
     * We recommend using a value between the start date and the end date of the event
     */
    @NotNull
    @FutureOrPresent
    private LocalDateTime startDateTime;

    /**
     * The end date and time which the prestation will be ended in the event timeline.
     * <br/>
     * This field as a {@code LocalDateTime} should be not null and a present DateTime
     * or a DataTime in the future. Past value is not allowed.
     * <br/>
     * It's recommended that this value will be a future value comparing to the
     * {@code startDateTime} of the prestation but should be less than the end date and time
     * of the concerned event
     */
    @NotNull
    @FutureOrPresent
    private LocalDateTime endDateTime;

    /**
     * The event where the service will be performed.
     */
    @NotNull
    private Event event;

    /**
     * The service which will be the subject of the prestation.
     */
    @NotNull
    private ServiceEvent serviceEvent;

    /**
     * The service provider
     */
    @Null
    private User user;
}
