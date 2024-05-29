package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.Place;
import com.fapethedev.tendance.events.form.PlaceForm;
import com.fapethedev.tendance.events.repository.PlaceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>Service layer class that's implements {@code IPlaceService}.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 * @see com.fapethedev.tendance.events.services.IPlaceService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceService implements IPlaceService
{
    /**
     * <p>Place database layer interface.</p>
     */
    private final PlaceRepository placeRepository;

    @Override
    public Place save(Place place)
    {
        log.info("Saving Place");

        return placeRepository.save(place);
    }

    @Override
    public Place save(PlaceForm placeForm)
    {
        log.info("Adding new Place by using place form");

        Place place = new Place();
        place.setName(placeForm.getName());
        place.setLatitude(place.getLatitude());
        place.setLongitude(place.getLongitude());
        place.setCountry(placeForm.getCountry());
        place.setCity(placeForm.getCity());
        place.setTown(placeForm.getTown());
        place.setScope(placeForm.getScope());

        return placeRepository.save(place);
    }

    @Override
    public Place delete(Place place)
    {
        log.info("Deleting Place " + place.getName() + ", with id : " + place.getId());

        placeRepository.delete(place);

        return place;
    }

    @Override
    public Place deleteById(UUID uuid)
    {
        log.info("Deleting Place with id : " + uuid);

        return delete(findById(uuid));
    }

    @Override
    public Place findById(UUID uuid)
    {
        log.info("Fetching Place with id : " + uuid);

        return placeRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Place with id : " + uuid + " not found"));
    }

    @Override
    public List<Place> findAll()
    {
        return placeRepository.findAll();
    }

    @Override
    public Place findByName(String name)
    {
        log.info("Fetching Place with name : " + name);

        return placeRepository.findByNameLikeIgnoreCase(name)
                .orElseThrow(() -> new EntityNotFoundException("Place with name : " + name + " not found"));
    }
}
