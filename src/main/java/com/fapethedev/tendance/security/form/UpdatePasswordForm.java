package com.fapethedev.tendance.security.form;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * <p>{@code UpdatePasswordForm} is the form representation for update password.
 * The form contains three required field, the current password, the new password
 * and confirmation password aka the confirmation of the new password</p>
 *
 * @author Fapethedev
 * @version 1.0
 */
@Data
public class UpdatePasswordForm
{
    /**
     * <p>The user current password field.
     * This field is mandatory and don't allow nullable value or empty string.</p>
     */
    @NotBlank(message = "Votre mot de passe actuel est requis")
    private String currentPassword;

    /**
     * <p>The user new password field.
     * The new password should be eighty characters long as minimum length.</p>
     *
     * <p>This field is mandatory and don't allow nullable value or empty string.</p>
     */
    @NotBlank(message = "Vous devez specifier un mot de passe")
    @Length(min = 8, max = 255, message = "Le mot de passe doit contenir au minimum 8 caractere")
    private String newPassword;

    /**
     * <p>The confirmation new password field.
     * The confirmation password should be eighty characters long as minimum length.</p>
     *
     * <p>It's mandatory that this field should have the same value as the new password field
     * to avoid errors.
     * This field is mandatory and don't allow nullable value or empty string.</p>
     */
    @NotBlank(message = "Vous devez confirmez votre mot de passe")
    @Length(min = 8, max = 255, message = "Le mot de passe doit contenir au minimum 8 caractere")
    private String confirmPassword;
}
