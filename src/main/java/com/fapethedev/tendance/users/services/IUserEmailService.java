package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.users.entities.User;

/**
 * <p>Service layer for define different email that will be send to a
 * user according user relative action like registering and others</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public interface IUserEmailService
{
    /**
     * <p>Send a registration success message to
     * a new user to activate his account.</p>
     *
     * @param user the user to activate his account
     */
    void sendRegisterConfirmationEmail(User user);

    /**
     * <p>Send an email to a user that's is fully registered in the application.
     * This is usefully for telling user that their account is successfully activated
     * even they use oauth2 protocol to register their account.</p>
     *
     * @param user the user with the account activates and with minimum base setup
     */
    void sendRegistrationCompleteEmail(User user);

    /**
     * <p>Send an email to inform a user that his no longer a standard user and
     * his account type has changed.</p>
     *
     * @param user the user that saw his type changed
     */
    void sendUserTypeChangeEmail(User user);
}
