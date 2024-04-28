package com.fapethedev.tendance.main.exception;

/**
 * Global exception for entities not found in database query
 * @author Fapethedev
 * @since 1.0
 */
public class EntityNotFoundException extends RuntimeException
{
    /**
     * Default constructor with string parameter
     * @param message the exception message toward
     */
    public EntityNotFoundException(String message) {
        super(message);
    }

    /**
     * Default constructor with {@link Throwable} parameter
     * Use when needed to just know the cause of the exception
     * @param cause the object that throws the exception
     */
    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor for both string and {@link Throwable}
     * To use when it's needed to pass a specific exception message
     * and the cause of the exception
     * @param message the exception message toward
     * @param cause the object that throws the exception
     */
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
