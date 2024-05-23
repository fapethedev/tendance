package com.fapethedev.tendance.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <p>{@code ApplicationAsynchronousConfiguration} is the
 * configuration class for enable asynchronous processing in the application .</p>
 *
 * @author Fapethedev
 * @version 1.0
 */
@EnableAsync
@Configuration
public class ApplicationAsynchronousConfiguration
{
    /**
     * <p>Bean method that will return an instance of {@code ApplicationEventMulticaster}
     * for enabling asynchronous processing for application event and
     * {@code AbstractApplicationBaseEvent} realizations.</p>
     *
     * @return {@code ApplicationEventMulticaster} implementation
     * which is inject when a bean is required for asynchronous events processing
     */
    @Lazy
    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster()
    {
        var eventMulticaster = new SimpleApplicationEventMulticaster();

        eventMulticaster.setTaskExecutor(new  SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }
}
