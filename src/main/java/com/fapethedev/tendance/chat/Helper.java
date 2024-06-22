package com.fapethedev.tendance.chat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.ExecutorSubscribableChannel;

/**
 * <p>Helper class for the injection of a static bean of SimpMessagingTemplate.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public class Helper
{
    @Bean
    @Primary
    public static SimpMessagingTemplate getMessagingTemplate()
    {
        return new SimpMessagingTemplate(new ExecutorSubscribableChannel());
    }
}
