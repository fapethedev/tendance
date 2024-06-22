package com.fapethedev.tendance.security.publisher;

import com.fapethedev.tendance.main.publisher.AbstractApplicationBaseEvent;
import com.fapethedev.tendance.users.entities.User;
import lombok.Getter;

/**
 * <p>This the prior event trigger when a user
 * who has account forget his password and then decides to
 * reset his password user his mail address.</p>
 *
 * @see AbstractApplicationBaseEvent
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Getter
public class PasswordResetConfirmEvent extends AbstractApplicationBaseEvent
{
    private final String password;

    /**
     * <p>Creates a new event for reset a user-forgotten
     * password.</p>
     *
     * @param user the user who's trying to reset his password
     */
    public PasswordResetConfirmEvent(User user, String password)
    {
        super(user);
        this.password = password;
    }
}
