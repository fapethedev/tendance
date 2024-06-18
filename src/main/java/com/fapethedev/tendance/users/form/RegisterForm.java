package com.fapethedev.tendance.users.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * <p>Form object to get user registration information from the front-end
 * to the back-end.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Data
public class RegisterForm
{
    @NotNull
    @NotBlank(message = "Le nom ne doit pas être laissé vide")
    private String lastname;

    @NotNull
    @NotBlank(message = "Le prenom ne doit pas être laissé vide")
    private String firstname;

    @NotNull
    @NotBlank(message = "Le email ne doit pas être laissé vide")
    @Email(message = "Entrez une adresse email valide")
    private String email;

    @NotNull
    @NotBlank(message = "Le mot de passe ne doit pas être laissé vide")
    @Length(min = 8, max = 255, message = "Le mot de passe doit contenir au minimum 8 caractères")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$\n",
            message = """
                        Le mot de passe doit contenir au moins 1 lettre majuscule, 1 lettre minuscule, 1 chiffre et 1 caractère spécial
                    """)
    private String password;

    @NotNull
    @NotBlank(message = "Le telephone ne doit pas être laissé vide")
    private String phone;
}
