package com.fapethedev.tendance.security.services;

import com.fapethedev.tendance.main.services.AbstractEmailService;
import com.fapethedev.tendance.users.entities.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

/**
 * <p>{@code SecurityEmailService} is the {@link ISecurityEmailService} implementation
 * for creating and sending security related email to a specific user </p>
 * @author Fapethedev
 * @version 1.0
 * @see com.fapethedev.tendance.main.services.AbstractEmailService
 * @see com.fapethedev.tendance.security.services.ISecurityEmailService
 */
@Service
@Slf4j
public class SecurityEmailService extends AbstractEmailService implements ISecurityEmailService
{
    public SecurityEmailService(JavaMailSender mailSender, ITemplateEngine engine) {
        super(mailSender, engine);
    }

    @Override
    public void sendPasswordResetEmail(User user)
    {
        MimeMessage message = mailSender.createMimeMessage();

        Context context = new Context();
        context.setVariable("user", user);

        String text = engine.process("mail/reset-password-email", context);

        log.info("Sending reset password email");

        try
        {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(appMailSender);
            helper.setTo(user.getIdentity().getEmail());
            helper.setSubject("Réinitialiser le mot de passe - Tendance");
            helper.setText(text, true);

            mailSender.send(message);
        }
        catch (MessagingException e)
        {
            log.warn("Failed to send reset password email", e);
        }
    }

    @Override
    public void sendPasswordResetConfirmEmail(User user, String password) {
        return;
    }

    @Override
    public void sendPasswordChangeEmail(User user)
    {
        MimeMessage message = mailSender.createMimeMessage();

        Context context = new Context();
        context.setVariable("user", user);

        String text = engine.process("mail/change-password-email", context);

        log.info("Sending password successfully changed email");

        try
        {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(appMailSender);
            helper.setTo(user.getIdentity().getEmail());
            helper.setSubject("Mot de Passe modifié - Tendance");
            helper.setText(text, true);

            mailSender.send(message);
        }
        catch (MessagingException e)
        {
            log.warn("Failed to send password change email", e);
        }
    }
}
