package com.fapethedev.tendance.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * <p>Configuration for session storage using Redis as an application cache.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Configuration
@EnableRedisHttpSession
public class ApplicationSessionConfiguration extends AbstractHttpSessionApplicationInitializer
{
    /**
     * Creates a new connection with redis factory.
     *
     * @return a redis session factory instance
     */
    @Bean
    public JedisConnectionFactory connectionFactory()
    {
        return new JedisConnectionFactory();
    }
}