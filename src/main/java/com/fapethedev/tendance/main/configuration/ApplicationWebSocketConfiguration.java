package com.fapethedev.tendance.main.configuration;

import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * <p>Configuration class for enabling the usage of web socket protocole through the app.</p>
 *
 * <p>This class implements {@code WebSocketMessageBrokerConfigurer} and
 * redefines the needed methods such as message brokers or stomp endpoints.</p>
 *
 * @see org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Configuration
@EnableWebSocketMessageBroker
public class ApplicationWebSocketConfiguration implements WebSocketMessageBrokerConfigurer
{
    /**
     * <p>Configure how the application should configure the {@code MessageBrokerRegistry}.</p>
     *
     * @param registry the message broker registry where application prefixes
     * and other configuration for messages brokers are defined
     */
    @Override
    public void configureMessageBroker(@NonNull MessageBrokerRegistry registry)
    {
        registry.setApplicationDestinationPrefixes("/app")
                .setUserDestinationPrefix("/user")
                .enableSimpleBroker("/user", "/settings", "/chat");

    }

    /**
     * <p>Configure path for message broadcast and from where message suppose to come.</p>
     *
     * @param registry the stomp endpoint registry where the application is waiting for messages
     * to be broadcast
     */
    @Override
    public void registerStompEndpoints(@NonNull StompEndpointRegistry registry)
    {
        registry.addEndpoint("/settings");
        registry.addEndpoint("/settings")
                .withSockJS();

        registry.addEndpoint("/chat");
        registry.addEndpoint("/chat")
                .withSockJS();
    }
}
