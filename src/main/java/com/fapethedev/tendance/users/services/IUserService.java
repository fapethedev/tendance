package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.main.services.IService;
import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.exceptions.UserNotFoundException;
import com.fapethedev.tendance.users.form.RegisterForm;
import com.fapethedev.tendance.users.form.UserForm;

import java.util.UUID;

/**
 * <p>Service layer interface for crud operation on {@code User} entities.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public interface IUserService extends IService<User, UUID, UserForm>
{
    /**
     * Get a user using his email.
     * 
     * @param email the email of the user. This email acts like the username too
     *
     * @return {@code User} with the corresponding email
     *
     * @throws UserNotFoundException if no user is found
     */
    User findUserByEmail(String email) throws UserNotFoundException;

    /**
     * Check if an email is associated with a user.
     *
     * @param email the email of the user.
     *
     * @return true if a user has this email, false otherwise
     */
    boolean existByEmail(String email);

    /**
     * <p>Save a new user through a registration form.</p>
     *
     * @param form the form filled by the user to register
     *
     * @return the new user
     */
    User save(RegisterForm form);
}
