package com.fapethedev.tendance.payments.sales.form;

import com.fapethedev.tendance.payments.sales.entities.Pass;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>The form for creating a pack of tickets.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Builder
@Getter @Setter
public class PackForm extends PassForm
{
    /**
     * <p>The list of tickets that's compose the pass.</p>
     */
    @NotNull(message = "La liste des ticket du pack ne doit pas être null")
    @NotEmpty(message = "La liste des ticket du pack ne doit pas être vide")
    private List<Pass> passes;
}
