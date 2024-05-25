package com.fapethedev.tendance.security.publisher;

/**
 * <p>Password event listeners interface.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public interface IPasswordEventListener
{
    /**
     * <p>Listening a {@code PasswordResetEvent} and made the right process.</p>
     *
     * @param event the reset password event
     */
    void onPasswordResetEvent(PasswordResetEvent event);

    /**
     * <p>Listening a {@code PasswordChangeEvent} and made the right process.</p>
     *
     * @param event the change password event
     */
    void onPasswordChangeEvent(PasswordChangeEvent event);
}
