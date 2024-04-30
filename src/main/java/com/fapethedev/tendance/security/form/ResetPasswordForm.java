package com.fapethedev.tendance.security.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class ResetPasswordForm
{
    @Email
    @NotNull
    private String email;

    @Null
    private String token;
}
