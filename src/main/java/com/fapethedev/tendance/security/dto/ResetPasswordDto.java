package com.fapethedev.tendance.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResetPasswordDto
{
    @Email
    @NotNull
    private String email;
}
