package com.fapethedev.tendance.events.repository;

import com.fapethedev.tendance.events.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * {@code EventRepository} is an interface for querying {@link Event}
 * table from the database using {@code JpaRepository} methods
 * @author Fapethedev
 * @since 1.0
 * @implSpec {@link JpaRepository} for query methods
 */
@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
}
