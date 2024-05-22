package com.fapethedev.tendance.users.publisher;

import com.fapethedev.tendance.main.publisher.AbstractApplicationBaseEvent;
import com.fapethedev.tendance.users.entities.User;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>{@code UserRegisterEvent} define the event which is
 * trigger by a user fill up and submit a valid the registration form</p>
 *
 * @see com.fapethedev.tendance.main.publisher.AbstractApplicationBaseEvent
 * @see UserRegisterCompleteEvent
 * @author Fapethedev
 * @version 1.0
 */
@Getter @Setter
public class UserRegisterEvent extends AbstractApplicationBaseEvent
{
    public UserRegisterEvent(User user)
    {
        super(user);
    }
}
