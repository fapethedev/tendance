package com.fapethedev.tendance.payments.subscriptions.repository;

import com.fapethedev.tendance.payments.subscriptions.entities.Functionality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * <p>The functionality entity redis layer interface.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Repository
public interface FunctionalityRedisRepository extends CrudRepository<Functionality, UUID> {
}
