package com.fapethedev.tendance.main.publisher;

import com.fapethedev.tendance.users.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * <p>{@code AbstractApplicationBaseEvent} has the role to define the relationship
 * between {@code ApplicationEvent} and {@code User}.
 * </p>
 */
@Getter @Setter
public abstract class AbstractApplicationBaseEvent extends ApplicationEvent
{
    /**
     * <p>The user that's may perform the action relative to the event.</p>
     */
    protected User user;

    /**
     * <p>Base constructor for linking and save a placeholder for the user associate with the event.</p>
     * @param user that trigger the event
     */
    public AbstractApplicationBaseEvent(User user)
    {
        super(user);
        this.user = user;
    }
}
