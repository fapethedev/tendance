package com.fapethedev.tendance.payments.sales.form;

import com.fapethedev.tendance.events.entities.Event;
import com.fapethedev.tendance.main.constants.CurrencyCode;
import com.fapethedev.tendance.payments.sales.entities.Pass;
import com.fapethedev.tendance.payments.sales.entities.PassState;
import com.fapethedev.tendance.payments.sales.entities.PassType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>The form for creating a pack of tickets.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Getter @Setter
public class PackForm extends PassForm
{
    /**
     * <p>Empty pack form constructor.</p>
     */
    public PackForm() {
        super();
    }

    /**
     * <p>Pack form constructor with passes list.</p>
     *
     * @param passes the list of passes
     */
    public PackForm(List<Pass> passes) {
        super();
        this.passes = passes;
    }

    /**
     * <p>Super class all args constructor matching with passes list.</p>
     */
    public PackForm(String logo,
                    @NotNull(message = "Le prix du ticket ne peut pas être null")
                    @Positive(message = "Le prix du ticket doit être supérieur à 0.00")
                    Double price,
                    @NotNull(message = "La devise du ticket ne doit pas être null")
                    CurrencyCode currency,
                    @NotNull(message = "La quantité en stock du ticket ne peut pas être null")
                    @PositiveOrZero(message = "La quantité en stock du ticket doit être supérieur ou égale à zéro")
                    Integer stock, @NotNull(message = "L'état du ticket ne peut pas être null")
                    PassState passState,
                    @NotNull(message = "Le type du ticket ne peut pas être null")
                    PassType passType,
                    @NotNull(message = "L'évènement du ticket ne peut pas être null")
                    Event event, List<Pass> passes)
    {
        super(logo, price, currency, stock, passState, passType, event);
        this.passes = passes;
    }

    /**
     * <p>The list of tickets that's compose the pass.</p>
     */
    @NotNull(message = "La liste des ticket du pack ne doit pas être null")
    @NotEmpty(message = "La liste des ticket du pack ne doit pas être vide")
    private List<Pass> passes;
}
