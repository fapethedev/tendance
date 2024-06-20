package com.fapethedev.tendance.main.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import java.time.Duration;

/**
 * <p>Configuration for session storage using Redis as an application cache.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "redis")
@Getter @Setter
@EnableRedisHttpSession
public class ApplicationSessionConfiguration extends AbstractHttpSessionApplicationInitializer
{
    /**
     * <p>Redis instance url</p>
     */
    @Value("${spring.data.redis.url}")
    private String url;

    /**
     * <p>If the redis connection is use ssl or not.</p>
     */
    private boolean useSSL;

    /**
     * <p>Redis command timeout value</p>
     */
    private int timeout;

    /**
     * Creates a new connection with redis factory.
     * Use the server url to create a redis configuration overriding
     * default configuration for the redis connection.
     *
     * @return a redis session factory instance with the redis server url
     */
    @Bean
    @Lazy
    public LettuceConnectionFactory connectionFactory()
    {
        return useSSL ?
                new LettuceConnectionFactory(
                        LettuceConnectionFactory.createRedisConfiguration(url),
                        LettuceClientConfiguration.builder()
                                .commandTimeout(Duration.ofMillis(timeout))
                                .useSsl()
                                .build()
                        ) :
                new LettuceConnectionFactory(LettuceConnectionFactory.createRedisConfiguration(url));
    }
}