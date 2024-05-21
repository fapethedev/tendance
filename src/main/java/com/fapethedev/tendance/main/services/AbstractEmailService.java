package com.fapethedev.tendance.main.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.ITemplateEngine;

/**
 * <p>Top class for all EmailService.It's define the base configuration</p>
 * @author Fapethedev
 * @version 1.0
 */
public abstract class AbstractEmailService
{
    /**
     * <p>The app noreply email adress, there is a concern regarding this.</p>
     * <br/>
     * <p>Be aware that this address may not be use if there is a smtp relay server</p>
     */
    @Value("${app.mail.send}")
    protected String appMailSender;

    /**
     * <p>The java mail sender. It's allow to create and send the different type of email</p>
     */
    protected final JavaMailSender mailSender;

    /**
     * <p>Email processing engine for a particular context given a specific email template</p>
     */
    protected final ITemplateEngine engine;

    /**
     * <p>Base constructor for email service</p>
     * @param mailSender the email sender
     * @param engine the email template processing engine
     */
    public AbstractEmailService(JavaMailSender mailSender, ITemplateEngine engine) {
        this.mailSender = mailSender;
        this.engine = engine;
    }
}
