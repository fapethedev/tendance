package com.fapethedev.tendance.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 * Data access object for user authentication's
 * @author Fapethedev
 * @version 1.0
 */
@Data
@ToString
public class UserLoginDto
{
    @NotNull
    @NotBlank(message = "Le nom d'utilisateur ne doit pas être laissé vide")
    private String username;

    @NotNull
    @NotBlank(message = "Le mot de passe ne doit pas être laissez vide")
    @Length(min = 8, max = 255, message = "Le mot de passe doit contenir au minimum 8 caractere")
    private String password;
}
