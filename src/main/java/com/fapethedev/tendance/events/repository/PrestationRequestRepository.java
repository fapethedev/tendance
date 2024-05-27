package com.fapethedev.tendance.events.repository;

import com.fapethedev.tendance.events.entities.PrestationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * {@code RequestPrestationRepository} is an interface for querying
 * {@link PrestationRequest} table from the database using
 * {@code JpaRepository} methods
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 *
 * @implSpec {@link JpaRepository} for query methods
 */
@Repository
public interface PrestationRequestRepository extends JpaRepository<PrestationRequest, UUID> {

}
