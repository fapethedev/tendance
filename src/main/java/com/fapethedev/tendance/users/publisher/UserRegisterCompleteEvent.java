package com.fapethedev.tendance.users.publisher;

import com.fapethedev.tendance.main.publisher.AbstractApplicationBaseEvent;
import com.fapethedev.tendance.users.entities.User;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>{@code UserRegisterCompleteEvent} define the event which is
 * trigger by a user after end up his registration.</p>
 * <p>The objective of this event is to activate the user
 * account and allow him to connect to our platform.</p>
 *
 * @see com.fapethedev.tendance.main.publisher.AbstractApplicationBaseEvent
 * @see UserRegisterEvent
 * @author Fapethedev
 * @version 1.0
 */
@Getter @Setter
public class UserRegisterCompleteEvent extends AbstractApplicationBaseEvent
{
    public UserRegisterCompleteEvent(User user)
    {
        super(user);
    }
}
