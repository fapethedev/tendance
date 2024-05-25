package com.fapethedev.tendance.security.publisher;

import com.fapethedev.tendance.main.publisher.AbstractApplicationBaseEvent;
import com.fapethedev.tendance.users.entities.User;

/**
 * <p>This the prior event trigger when a user
 * who has account forget his password and then decides to
 * reset his password user his mail address.</p>
 *
 * @see com.fapethedev.tendance.main.publisher.AbstractApplicationBaseEvent
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public class PasswordResetEvent extends AbstractApplicationBaseEvent
{
    /**
     * <p>Creates a new event for reset a user-forgotten
     * password.<p/>
     *
     * @param user the user who's trying to reset his password
     */
    public PasswordResetEvent(User user)
    {
        super(user);
    }
}
