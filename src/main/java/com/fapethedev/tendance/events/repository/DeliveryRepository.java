package com.fapethedev.tendance.events.repository;

import com.fapethedev.tendance.events.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * {@code DeliveryRepository} is an interface for querying {@link Delivery}
 * table from the database using {@code JpaRepository} methods
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 *
 * @implSpec {@link JpaRepository} for query methods
 */
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {
}
