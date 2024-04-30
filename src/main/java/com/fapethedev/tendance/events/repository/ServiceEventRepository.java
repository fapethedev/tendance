package com.fapethedev.tendance.events.repository;

import com.fapethedev.tendance.events.entities.ServiceEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * {@code ServiceEventRepository} is an interface for querying {@link ServiceEvent}
 * table from the database using {@code JpaRepository} methods
 * @author Fapethedev
 * @since 1.0
 * @implSpec {@link JpaRepository} for query methods
 */
@Repository
public interface ServiceEventRepository extends JpaRepository<ServiceEvent, UUID> {
}
