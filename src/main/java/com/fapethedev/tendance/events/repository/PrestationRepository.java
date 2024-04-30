package com.fapethedev.tendance.events.repository;

import com.fapethedev.tendance.events.entities.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * {@code PrestationRepository} is an interface for querying {@link Prestation}
 * table from the database using {@code JpaRepository} methods
 * @author Fapethedev
 * @since 1.0
 * @implSpec {@link JpaRepository} for query methods
 */
@Repository
public interface PrestationRepository extends JpaRepository<Prestation, UUID> {
}
