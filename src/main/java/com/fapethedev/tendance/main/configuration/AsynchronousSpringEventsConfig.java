package com.fapethedev.tendance.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * <p>{@code AsynchronousSpringEventsConfig} is a main configuration class for enable async event on the application.</p>
 * @author Fapethedev
 * @version 1.0
 */
@Configuration
public class AsynchronousSpringEventsConfig
{
    /**
     * <p>Bean method that will return an instance of {@code ApplicationEventMulticaster} when
     * an application event needed to be process.</p>
     * @return ApplicationEventMulticaster implementation
     */
    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster()
    {
        var eventMulticaster = new SimpleApplicationEventMulticaster();

        eventMulticaster.setTaskExecutor(new  SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }
}
