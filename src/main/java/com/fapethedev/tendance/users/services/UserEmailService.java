package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.users.entities.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author Fapethedev
 * @version 1.0
 *
 * An implementation of {@link IUserEmailService}
 */
@Component
@Slf4j
public class UserEmailService implements IUserEmailService
{
    private final JavaMailSender mailSender;

    /**
     * The app noreply mail adress
     */
    @Value("${app.mail.send}")
    private String appMailSender;

    private ITemplateEngine engine;

    public UserEmailService(JavaMailSender mailSender, ITemplateEngine engine) {
        this.mailSender = mailSender;
        this.engine = engine;
    }

    @Override
    public void sendRegisterConfirmationEmail(User user)
    {
        MimeMessage message = mailSender.createMimeMessage();

        Context context = new Context();
        context.setVariable("user", user);

        String text = engine.process("mail/register-email", context);

        log.info("Sending subscription success message");

        try
        {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(appMailSender);
            helper.setTo(user.getIdentity().getEmail());
            helper.setSubject("Inscription - Tendance");
            helper.setText(text, true);

            mailSender.send(message);
        }
        catch (MessagingException e)
        {
            log.warn("Failed to send subscription success message", e);
        }
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
