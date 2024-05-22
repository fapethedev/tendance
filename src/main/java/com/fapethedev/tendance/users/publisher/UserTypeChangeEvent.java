package com.fapethedev.tendance.users.publisher;

import com.fapethedev.tendance.main.publisher.AbstractApplicationBaseEvent;
import com.fapethedev.tendance.users.entities.User;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>{@code UserTypeChangeEvent} is the event which is trigger by a user when he's
 * trying to change is type in the profile settings page.</p>
 *
 * @see com.fapethedev.tendance.main.publisher.AbstractApplicationBaseEvent
 *
 * @author Fapethedev
 * @version 1.0
 */
@Getter @Setter
public class UserTypeChangeEvent extends AbstractApplicationBaseEvent
{
    /**
     * <p>The new type that the user subscribes to.</p>
     */
    private User.Type type;

    public UserTypeChangeEvent(User user, User.Type type)
    {
        super(user);
        this.type = type;
    }
}
