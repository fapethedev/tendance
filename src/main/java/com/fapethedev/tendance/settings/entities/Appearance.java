package com.fapethedev.tendance.settings.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import com.fapethedev.tendance.users.entities.User;

import java.util.UUID;

/**
 * <p>UI Appearance entities.
 * Has the role to assure a constant and mutable
 * ui appearance through the application and user ui configuration.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public class Appearance extends BaseEntity<UUID>
{
    private Theme theme;
    private Direction direction;
    private Color color;
    private Layout layout;
    private Sizing sizing;
    private Border border;
    private Card card;

    private User user;
}
