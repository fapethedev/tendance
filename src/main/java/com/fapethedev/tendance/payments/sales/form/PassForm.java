package com.fapethedev.tendance.payments.sales.form;

import com.fapethedev.tendance.events.entities.Event;
import com.fapethedev.tendance.main.constants.CurrencyCode;
import com.fapethedev.tendance.payments.sales.entities.PassState;
import com.fapethedev.tendance.payments.sales.entities.PassType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Form for creating a ticket.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassForm
{
    /**
     * <p>The logo field in the form.</p>
     */
    protected String logo;

    /**
     * <p>The ticket price field in the form, should be non null
     * and strict positive float.</p>
     */
    @NotNull(message = "Le prix du ticket ne peut pas être null")
    @Positive(message = "Le prix du ticket doit être supérieur à 0.00")
    protected Double price;

    /**
     * <p>The currency code field.</p>
     */
    @NotNull(message = "La devise du ticket ne doit pas être null")
    protected CurrencyCode currency;

    /**
     * <p>The available quantity of ticket, should be a non value and
     * positive or zero integer value.</p>
     */
    @NotNull(message = "La quantité en stock du ticket ne peut pas être null")
    @PositiveOrZero(message = "La quantité en stock du ticket doit être supérieur ou égale à zéro")
    protected Integer stock;

    /**
     * <p>The state of the ticket field in the form.</p>
     */
    @NotNull(message = "L'état du ticket ne peut pas être null")
    protected PassState passState;

    /**
     * <p>The type of the ticket field in the form.</p>
     */
    @NotNull(message = "Le type du ticket ne peut pas être null")
    protected PassType passType;

    /**
     * <p>The event which is used the ticket field in the form.</p>
     */
    @NotNull(message = "L'évènement du ticket ne peut pas être null")
    protected Event event;
}
