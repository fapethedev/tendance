package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.Place;
import com.fapethedev.tendance.events.form.PlaceForm;
import com.fapethedev.tendance.main.exception.EntityNotFoundException;
import com.fapethedev.tendance.main.services.IService;

import java.util.UUID;

/**
 * Service Layer for {@code Place}
 * @author Fapethedev
 * @since 1.0
 * @see com.fapethedev.tendance.main.services.IService
 */
public interface IPlaceService extends IService<Place, UUID, PlaceForm>
{
    /**
     * Get a place with the specified name
     * @param name the name of the place
     * @return The {@code Place} with the given name
     * @throws com.fapethedev.tendance.main.exception.EntityNotFoundException
     * if no place with the given found
     */
    Place findByName(String name) throws EntityNotFoundException;
}
