package com.fapethedev.tendance.users.services;

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
 * <p>The major implementation of {@link IUserEmailService}
 * for sending email related to users.</p>
 *
 * @see com.fapethedev.tendance.users.services.IUserEmailService for UserEmailService methods
 * @see com.fapethedev.tendance.main.services.AbstractEmailService for EmailService configurations
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 *
 */
@Service
@Slf4j
public class UserEmailService extends AbstractEmailService implements IUserEmailService
{
    public UserEmailService(JavaMailSender mailSender, ITemplateEngine engine) {
        super(mailSender, engine);
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
