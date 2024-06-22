package com.fapethedev.tendance.security.publisher;

import com.fapethedev.tendance.security.manager.UserLoginManager;
import com.fapethedev.tendance.security.services.ISecurityEmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PasswordEventListenerImpl implements IPasswordEventListener
{
    private final ISecurityEmailService service;
    private final UserLoginManager userLoginManager;

    /**
     *
     * @param event
     */
    @EventListener
    public void onPasswordResetEvent(PasswordResetEvent event)
    {
        log.info("Listening password reset event");

        log.info("Sending password reset email");
        service.sendPasswordResetEmail(event.getUser());
    }

    /**
     *
     * @param event
     */
    @EventListener
    public void onPasswordResetConfirmEvent(PasswordResetConfirmEvent event)
    {
        log.info("Listening password reset event");

        log.info("Resetting password");
        userLoginManager.updatePassword(event.getUser(), event.getPassword());

        log.info("Sending password reset email");
        service.sendPasswordResetConfirmEmail(event.getUser(), event.getPassword());
    }

    /**
     *
     * @param event
     */
    @EventListener
    public void onPasswordChangeEvent(PasswordChangeEvent event)
    {
        log.info("Listening password change event");

        log.info("Changing user password");
        userLoginManager.changePassword(event.getForm().getCurrentPassword(), event.getForm().getNewPassword());

        log.info("Sending password change email");
        service.sendPasswordChangeEmail(event.getUser());
    }
}
