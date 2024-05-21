package com.fapethedev.tendance.security.services;

import com.fapethedev.tendance.users.entities.User;

/**
 * <p>Service interface for handling sending security relative email to users.</p>
 * @author Fapethedev
 * @version 1.0
 */
public interface ISecurityEmailService
{
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
