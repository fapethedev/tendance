package com.fapethedev.tendance.settings.form;

import com.fapethedev.tendance.settings.entities.*;
import com.fapethedev.tendance.users.entities.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * <p>Form with validation when an user submit an {@code Appearance}.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Data
public class AppearanceForm
{
    private Theme theme;

    private Direction direction;

    private Color color;

    private Layout layout;

    private Sizing sizing;

    private Border border;

    private Card card;

    @NotNull(message = "L'utilisateur qui configure le l'apparence ne peut être null")
    private User user;
}
