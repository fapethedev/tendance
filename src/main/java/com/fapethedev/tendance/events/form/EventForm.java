package com.fapethedev.tendance.events.form;

import com.fapethedev.tendance.events.entities.EventState;
import com.fapethedev.tendance.users.entities.User;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * <p>{@code EventForm} is an object that serve as event form on the frontend.<br/>
 * Event form utility is to create and sometimes update an {@code Event}.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventForm
{
    /**
     * The name of the event in the {@code EventForm} is mandatory
     * <br/>
     * This field shouldn't be null or an empty string
     */
    @NotNull
    @NotBlank
    private String name;

    /**
     * The description of the event in the {@code EventForm} is mandatory
     * <br/>
     * This field shouldn't be null or an empty string
     */
    @NotNull
    @NotBlank
    private String description;

    /**
     * The start date and time of the event in the {@code EventForm} is mandatory
     * <br/>
     * This field as a {@code LocalDateTime} should be not null and a present DateTime
     * or a DataTime in the future. Past value is not allowed
     */
    @NotNull
    @FutureOrPresent
    private LocalDateTime startDateTime;

    /**
     * The end date and time of the event in the {@code EventForm} is mandatory
     * <br/>
     * This field as a {@code LocalDateTime} should be not null and a present DateTime
     * or a DataTime in the future. Past value is not allowed.
     * <br/>
     * It's recommended that this value will be a future value comparing to the {@code startDateTime} value
     */
    @NotNull
    @FutureOrPresent
    private LocalDateTime endDateTime;

    /**
     * Poster images of the event.
     */
    private MultipartFile imageOne;

    private MultipartFile imageTwo;

    private MultipartFile imageThree;

    /**
     * Promotional videos of the event
     */
    private MultipartFile videoOne;

    private MultipartFile videoTwo;

    private MultipartFile videoThree;

    /**
     * Event status. Defaults to PENDING to signify that the event is
     * created and awaiting publication.
     * <br/>
     * This field is left null when submitting the form
     */
    @Null
    private EventState eventState;

    /**
     * Place of the event.
     * Not a mandatory field and can be let null if no place is specified
     */
    private String place;

    /**
     * Scope is used to know if an event is public or not, nothing more.
     * <br/>
     * Depending on the value of this attribute, certain information about an
     * event will be displayed and other information will not.
     */
    @NotNull
    @NotBlank
    private String scope;

    /**
     * The event organizer
     * <br/>
     * Although this field is mandatory, it is left as null when submitting
     * the form.
     */
    @Null
    private User user;
}

