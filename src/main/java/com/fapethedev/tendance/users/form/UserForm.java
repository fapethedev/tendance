package com.fapethedev.tendance.users.form;

import com.fapethedev.tendance.users.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserForm
{
    @NotNull
    @NotBlank(message = "Le nom ne doit pas être laissez vide")
    private String lastname;

    @NotNull
    @NotBlank(message = "Le prenom ne doit pas être laissez vide")
    private String firstname;

    @NotNull
    @NotBlank(message = "Le email ne doit pas être laissez vide")
    @Email(message = "Entrez une adresse email valide")
    private String email;

    @NotNull
    @NotBlank(message = "Le mot de passe ne doit pas être laissez vide")
    @Length(min = 8, max = 255, message = "Le mot de passe doit contenier au minimum 8 caractere")
    private String password;

    @NotBlank(message = "Le telephone ne doit pas être laissez vide")
    @NotNull
    private String phone;

    @NotBlank(message = "Le ville ne doit pas être laissez vide")
    @NotNull
    private String city;

    @NotBlank(message = "Le pays ne doit pas être laissez vide")
    @NotNull
    private String country;

    private String nomOrganisation;

    private String emailOrganisation;

    private String siege;

    private String description;

    private String siteWeb;

    private String picture;

    private String bio;

    private String idProof;

    private User.UserType type;
}
