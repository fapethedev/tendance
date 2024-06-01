package com.fapethedev.tendance.payments.subscriptions.form;

import com.fapethedev.tendance.payments.subscriptions.entities.FunctionalityType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * <p>Form representation of {@code Functionality}.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Data
@Builder
public class FunctionalityForm {
    /**
     * <p>The functionality designation in the form.</p>
     */
    @Length(min = 4, message = "La désignation d'une fonctionnalité doit contenir quatre caractères minimum")
    @NotBlank(message = "La désignation d'une fonctionnalité ne peut être pas vide")
    @NotNull(message = "La désignation d'une fonctionnalité ne peut être pas null")
    private String designation;

    /**
     * <p>The description of the functionality in the form.</p>
     */
    @Length(min = 4, message = "La description d'une fonctionnalité doit contenir quatre caractères minimum")
    @NotBlank(message = "La description d'une fonctionnalité ne peut être pas vide")
    @NotNull(message = "La description d'une fonctionnalité ne peut être pas null")
    private String description;

    /**
     * <p>The functionality type in the form.</p>
     */
    @NotNull(message = "Le type de la fonctionnalité ne peut pas être null")
    private FunctionalityType type;
}
