package com.fapethedev.tendance.main.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Global exception for entities
 * @author Fapethedev
 * @since 1.0
 */
@Data
public class ContactForm
{
    @NotNull
    @NotBlank(message = "Veuillez spécifier le contenu de votre message")
    private String message;

    @NotNull
    @NotBlank(message = "Votre nom ne peut pas être laissez vide")
    private String name;

    @NotNull
    @NotBlank(message = "Veuillez saisir le sujet de votre message")
    private String subject;

    @NotNull
    @Email(message = "Veuillez entrer une adresse email valide")
    @NotBlank(message = "Veuillez saisir votre adresse email")
    private String email;
}
