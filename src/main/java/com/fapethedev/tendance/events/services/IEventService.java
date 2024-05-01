package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.Event;
import com.fapethedev.tendance.events.form.EventForm;
import com.fapethedev.tendance.main.services.IService;

import java.util.UUID;

/**
 * Service Layer for {@code Event}
 * @author Fapethedev
 * @since 1.0
 * @see com.fapethedev.tendance.main.services.IService
 */
public interface IEventService extends IService<Event, UUID, EventForm> {
}
