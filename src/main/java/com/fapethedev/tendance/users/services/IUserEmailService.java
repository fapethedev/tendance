package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.users.entities.User;

/**
 * <p>Service layer for define differents email that will be send to a
 * user according user relative action like registring and others</p
 * @author Fapethedev
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
}
