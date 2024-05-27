package com.fapethedev.tendance.events.form;

import com.fapethedev.tendance.events.entities.Delivery;
import com.fapethedev.tendance.users.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

/**
 * {@code DeliveryForm} is an object that serve as event form on the frontend.<br/>
 * DeliveryForm form utility is to create and sometimes update.
 * an {@link Delivery}
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Data @Builder
public class DeliveryForm
{
    /**
     * <p>The name of the event in the {@code EventForm} is mandatory.<br/>
     * <p>This field shouldn't be null or an empty string.</p>
     */
    @NotNull
    @NotBlank
    private String name;

    /**
     * The descripion of the event in the {@code EventForm} is mandatory
     * <br/>
     * This field shouldn't be null or an empty string
     */
    @NotNull
    @NotBlank
    private String description;

    /**
     * The cost of the service
     */
    @NotNull
    @PositiveOrZero
    private Double price;

    /**
     * The currency
     */
    @NotNull
    @NotBlank
    private String currency;

    /**
     * <p>Scope is used to know if an event is public or not, nothing more.</p>
     * <br/>
     * <p>Depending on the value of this attribute, certain information about an
     * event will be displayed and other information will not.</p>
     */
    @NotNull
    @NotBlank
    private String scope;

    /**
     * <p>The creator of the service. By default, a user with the type
     * service_provider.</p>
     */
    @NotNull
    private User user;
}

