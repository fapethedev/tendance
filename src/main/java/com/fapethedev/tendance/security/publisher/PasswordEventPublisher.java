package com.fapethedev.tendance.security.publisher;

import com.fapethedev.tendance.security.form.UpdatePasswordForm;
import com.fapethedev.tendance.security.manager.UserLoginManager;
import com.fapethedev.tendance.users.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class PasswordEventPublisher
{
    private final ApplicationEventMulticaster multicaster;

    /**
     *
     * @param user
     */
    public void publishPasswordResetEvent(User user)
    {
        log.info("Publishing password reset event");

        multicaster.multicastEvent(new PasswordResetEvent(user));
    }

    /**
     *
     * @param user
     */
    public void publishPasswordResetConfirmEvent(User user)
    {
        log.info("Publishing password reset event");

        multicaster.multicastEvent(new PasswordResetConfirmEvent(user, UserLoginManager.generateRandomPassword()));
    }

    /**
     *
     * @param user
     * @param form
     */
    public void publishPasswordChangeEvent(User user, UpdatePasswordForm form)
    {
        log.info("Publishing password change event");

        multicaster.multicastEvent(new PasswordChangeEvent(user, form));
    }
}
