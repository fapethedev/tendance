package com.fapethedev.tendance.events.repository;

import com.fapethedev.tendance.events.entities.Event;
import com.fapethedev.tendance.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * {@code EventRepository} is an interface for querying {@link Event}
 * table from the database using {@code JpaRepository} methods
 * @author Fapethedev
 * @since 1.0
 */
@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
    List<Event> findByUser(User user);
}
