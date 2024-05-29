package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.Place;
import com.fapethedev.tendance.events.form.PlaceForm;
import com.fapethedev.tendance.main.services.IService;
import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

/**
 * <p>Service layer interface for {@code Place}.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public interface IPlaceService extends IService<Place, UUID, PlaceForm>
{
    /**
     * Get a place with the specified name.
     *
     * @param name the name of the place
     *
     * @return The {@code Place} with the given name
     *
     * @throws EntityNotFoundException if no place with the given found
     */
    Place findByName(String name) throws EntityNotFoundException;
}
