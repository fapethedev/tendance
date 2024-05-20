package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.users.entities.User;

/**
 * @author Fapethedev
 * @version 1.0
 *
 * Service for handling sending message to users
 */
public interface IUserEmailService
{
    /**
     * Send a registration success message to
     *  a new user to activate his account
     * @param user the user to activate account
     */
    void sendRegisterConfirmationEmail(User user);

    /**
     * <p>Send a password reset confirmation email to the corresponding user.</p>
     * @param user who will try to reset his account password
     */
    void sendPasswordResetEmail(User user);

    /**
     * <p>Send email to the user after he successfully reset his password.<br/
     * This method could be use if a user manually changes his password.
     * </p>
     * @param user who confirm his password reset action from the reset password
     * url
     */
    void sendPasswordChangeEmail(User user);
}
