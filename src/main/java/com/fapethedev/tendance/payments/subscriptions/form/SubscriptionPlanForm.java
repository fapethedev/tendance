package com.fapethedev.tendance.payments.subscriptions.form;

import com.fapethedev.tendance.payments.subscriptions.entities.Functionality;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * <p>The form representation of a {@code SubscriptionPlan}.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Data
@Builder
public class SubscriptionPlanForm
{
    /**
     * <p>The title of the plan.</p>
     */
    @Length(min = 4, message = "Le contenu d'un plan d'abonnement doit contenir quatre caractères minimum")
    @NotBlank(message = "Le contenu d'un plan d'abonnement ne peut être pas vide")
    @NotNull(message = "Le contenu d'un plan d'abonnement ne peut être pas null")
    private String title;

    /**
     * <p>The content of the plan.</p>
     */
    @Length(min = 4, message = "Le contenu d'un plan d'abonnement doit contenir quatre caractères minimum")
    @NotBlank(message = "Le contenu d'un plan d'abonnement ne peut être pas vide")
    @NotNull(message = "Le contenu d'un plan d'abonnement ne peut être pas null")
    private String content;

    /**
     * <p>The price of the plan.</p>
     */
    @PositiveOrZero(message = "Le prix du plan doit être supérieur ou égale à zero")
    private Double price;

    /**
     * <p>Determines if the plan is available or not.</p>
     */
    @NotNull(message = "La disponibilité du plan doit être préciser")
    private Boolean isAvailable;

    /**
     * <p>All the functionalities include in the plan.</p>
     */
    @NotEmpty(message = "La liste des fonctionnalités ne peut pas être vide")
    @NotNull(message = "La liste des fonctionnalités ne peut pas être null")
    private List<Functionality> functionalities;
}
