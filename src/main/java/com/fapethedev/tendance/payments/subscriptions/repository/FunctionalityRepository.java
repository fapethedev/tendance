package com.fapethedev.tendance.payments.subscriptions.repository;

import com.fapethedev.tendance.payments.subscriptions.entities.Functionality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * <p>The functionality entity database layer interface.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Repository
public interface FunctionalityRepository extends JpaRepository<Functionality, UUID> {
}
