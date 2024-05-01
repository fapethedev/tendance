package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.ServiceEvent;
import com.fapethedev.tendance.events.form.ServiceEventForm;
import com.fapethedev.tendance.main.services.IService;

import java.util.UUID;

/**
 * Service Layer for {@code ServiceEvents}
 * @author Fapethedev
 * @since 1.0
 * @see com.fapethedev.tendance.main.services.IService
 */
public interface IServiceEventService extends IService<ServiceEvent, UUID, ServiceEventForm> {
}
