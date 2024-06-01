package com.fapethedev.tendance.payments.subscriptions.repository;

import com.fapethedev.tendance.payments.subscriptions.entities.UseHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * <p>The use history entity redis layer interface.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Repository
public interface UseHistoryRedisRepository extends CrudRepository<UseHistory, UUID> {

}
