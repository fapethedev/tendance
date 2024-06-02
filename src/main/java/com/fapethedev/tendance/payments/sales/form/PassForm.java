package com.fapethedev.tendance.payments.sales.form;

import com.fapethedev.tendance.events.entities.Event;
import com.fapethedev.tendance.main.constants.CurrencyCode;
import com.fapethedev.tendance.payments.sales.entities.PassState;
import com.fapethedev.tendance.payments.sales.entities.PassType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

/**
 * <p>Form for creating a ticket.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Data
@Builder
public class PassForm
{
    /**
     * <p>The logo field in the form.</p>
     */
    private String logo;

    /**
     * <p>The ticket price field in the form, should be non null
     * and strict positive float.</p>
     */
    @NotNull(message = "Le prix du ticket ne peut pas être null")
    @Positive(message = "Le prix du ticket doit être supérieur à 0.00")
    private Double price;

    /**
     * <p>The currency code field.</p>
     */
    @NotNull(message = "La devise du ticket ne doit pas être null")
    private CurrencyCode currency;

    /**
     * <p>The available quantity of ticket, should be a non value and
     * positive or zero integer value.</p>
     */
    @NotNull(message = "La quantité en stock du ticket ne peut pas être null")
    @PositiveOrZero(message = "La quantité en stock du ticket doit être supérieur ou égale à zéro")
    private Integer stock;

    /**
     * <p>The state of the ticket field in the form.</p>
     */
    @NotNull(message = "L'état du ticket ne peut pas être null")
    private PassState passState;

    /**
     * <p>The type of the ticket field in the form.</p>
     */
    @NotNull(message = "Le type du ticket ne peut pas être null")
    private PassType passType;

    /**
     * <p>The event which is used the ticket field in the form.</p>
     */
    @NotNull(message = "L'évènement du ticket ne peut pas être null")
    private Event event;
}
