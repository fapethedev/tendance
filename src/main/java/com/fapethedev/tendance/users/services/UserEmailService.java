package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.users.entities.User;

/**
 * @author Fapethedev
 * @version 1.0
 *
 * Service for handling sending message to users
 */
public interface UserEmailService
{
    /**
     * Send a registration success message to
     *  a new user to activate his account
     * @param user the user to activate account
     */
    void sendRegisterConfirmationEmail(User user);
}
