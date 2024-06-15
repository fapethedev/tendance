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
     * Send a registration success message to
     * a new user to activate his account
     * @param user the user to activate account
     */
    void sendRegisterConfirmationEmail(User user);

    /**
     * <p>Send an email to a user that's is fully registered in the application.
     * This is usefull for telling user that their account is successfully activated
     * even they use oauth2 protocol to register their account.</p>
     *
     * @param user the user with the account activate and with minimum base setup
     */
     void sendRegistrationCompleteEmail(User user);
}
