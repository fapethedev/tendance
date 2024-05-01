package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.Place;
import com.fapethedev.tendance.events.form.PlaceForm;
import com.fapethedev.tendance.main.services.IService;

import java.util.UUID;

/**
 * Service Layer for {@code Place}
 * @author Fapethedev
 * @since 1.0
 * @see com.fapethedev.tendance.main.services.IService
 */
public interface IPlaceService extends IService<Place, UUID, PlaceForm> {
}
