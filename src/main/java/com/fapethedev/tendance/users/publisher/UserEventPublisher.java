package com.fapethedev.tendance.users.publisher;

import com.fapethedev.tendance.users.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Component;

/**
 * <p>Concrete publisher class for publishing user event relative.
 * Use ApplicationEventMulticaster to publish the event in a dedicated thread different
 * from the main thread.</p>
 *
 * @see com.fapethedev.tendance.users.publisher.IUserEventPublisher
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class UserEventPublisher implements IUserEventPublisher
{
    /**
     * <p>The application event publisher.</p>
     */
    private final ApplicationEventMulticaster multicaster;

    @Override
    public void publishUserRegistrationEvent(User user)
    {
        log.info("Publishing user registration event for: " + user.getUsername());

        multicaster.multicastEvent(new UserRegisterEvent(user));
    }

    @Override
    public void publishUserRegistrationCompleteEvent(User user)
    {
        log.info("Publishing user registration complete event for: " + user.getUsername());

        multicaster.multicastEvent(new UserRegisterCompleteEvent(user));
    }

    @Override
    public void publishUserTypeChangeEvent(User user, User.Type type)
    {
        log.info("Publishing user type change event for: " + user.getUsername());

        multicaster.multicastEvent(new UserTypeChangeEvent(user, type));
    }
}
