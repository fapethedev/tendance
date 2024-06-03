package com.fapethedev.tendance.main.notification;

import com.fapethedev.tendance.main.publisher.AbstractApplicationBaseEvent;
import com.fapethedev.tendance.users.entities.User;
import lombok.Getter;


/**
 * <p>Event class for event on notification.</p>
 *
 * @see com.fapethedev.tendance.main.publisher.AbstractApplicationBaseEvent
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Getter
public class NotificationEvent extends AbstractApplicationBaseEvent
{
    /**
     * <p>The notification entity.</p>
     */
    private final NotificationEntity notification;

    /**
     * <p>Constructor for associating user to a notification entity
     * as an event.</p>
     *
     * @param user the user who triggers the event
     * @param notification the notification entity
     */
    public NotificationEvent(User user, NotificationEntity notification)
    {
        super(user);
        this.notification = notification;
    }
}
