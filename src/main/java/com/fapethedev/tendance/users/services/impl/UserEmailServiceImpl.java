package com.fapethedev.tendance.users.services.impl;

import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.services.UserEmailService;
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
 * An implementation of {@link UserEmailService}
 */
@Component
@Slf4j
public class UserEmailServiceImpl implements UserEmailService
{
    private final JavaMailSender mailSender;

    /**
     * The app noreply mail adress
     */
    @Value("${app.mail.send}")
    private String appMailSender;

    private ITemplateEngine engine;

    public UserEmailServiceImpl(JavaMailSender mailSender, ITemplateEngine engine) {
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
}
