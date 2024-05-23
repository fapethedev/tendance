package com.fapethedev.tendance.users.exceptions;

import jakarta.persistence.EntityNotFoundException;

/**
 * <p>Specialized exception class for User entity if they
 * was not found when querying the database through jpa.</p>
 *
 * @see jakarta.persistence.EntityNotFoundException
 * @see jakarta.persistence.PersistenceException
 *
 * @author Faoethedev
 * @version 1.0
 */
public class UserNotFoundException extends EntityNotFoundException
{
    public UserNotFoundException(String message) {
        super(message);
    }
}
