package com.fapethedev.tendance.security.publisher;

import com.fapethedev.tendance.main.publisher.AbstractApplicationBaseEvent;
import com.fapethedev.tendance.security.form.UpdatePasswordForm;
import com.fapethedev.tendance.users.entities.User;
import lombok.Getter;

/**
 * <p>Concret event which is intended to be trigger
 * after a user submits a valide password update form.</p>
 *
 * @see com.fapethedev.tendance.main.publisher.AbstractApplicationBaseEvent
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Getter
public class PasswordChangeEvent extends AbstractApplicationBaseEvent
{
    /**
     * The form with all passwords fields information.
     */
    private final UpdatePasswordForm form;

    /**
     * <p>Creates a password change event for the user
     * that submits a password update form.</p>
     *
     * @param user the user that triggers the event
     * @param form the form filed by the user
     */
    public PasswordChangeEvent(User user, UpdatePasswordForm form)
    {
        super(user);
        this.form = form;
    }
}
