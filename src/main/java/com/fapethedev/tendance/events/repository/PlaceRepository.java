package com.fapethedev.tendance.events.repository;

import com.fapethedev.tendance.events.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * {@code PlaceRepository} is an interface for querying {@link Place}
 * table from the database using {@code JpaRepository} methods
 * @author Fapethedev
 * @since 1.0
 */
@Repository
public interface PlaceRepository extends JpaRepository<Place, UUID>
{
    /**
     * Retrieving a {@code Place} using the place's name <br/>
     * It's recommend to use this method before insert a new place in the database
     * to avoid multiple record for the same place
     * @param name the place's name
     * @return {@code Optional<Place>}, empty if no place matches the name
     * otherwise the corresponding place
     */
    Optional<Place> findByNameLikeIgnoreCase(String name);
}
