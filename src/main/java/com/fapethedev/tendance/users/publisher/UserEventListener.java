package com.fapethedev.tendance.users.publisher;

import com.fapethedev.tendance.users.services.IUserEmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * <p>Concrete listener class for user relative event.</p>
 *
 * @see com.fapethedev.tendance.users.publisher.IUserEventListener
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class UserEventListener implements IUserEventListener
{
    public final IUserEmailService service;

    @Override
    @EventListener
    public void onRegistrationEvent(UserRegisterEvent event)
    {
        log.info("Listening to " + event.getUser().getUsername() + " after creating a new account" );

        service.sendRegisterConfirmationEmail(event.getUser());
    }

    @Override
    @EventListener
    public void onRegistrationCompleteEvent(UserRegisterCompleteEvent event) {

        log.info("Listening to " + event.getUser().getUsername() + " after completing his account registration" );

        service.sendRegistrationCompleteEmail(event.getUser());
    }

    @Override
    @EventListener
    public void onUserTypeChangeEvent(UserTypeChangeEvent event)
    {
        log.info("Listening to " + event.getUser().getUsername() + " after successfully change his type" );

        service.sendUserTypeChangeEmail(event.getUser());
    }
}
