package com.fapethedev.tendance.payments.subscriptions.repository;

import com.fapethedev.tendance.payments.subscriptions.entities.UseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * <p>The use history entity database layer interface.</p>
 *
 * @param <T> the type of user id
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Repository
public interface UseHistoryRepository<T extends Serializable> extends JpaRepository<UseHistory, UUID> {
    List<UseHistory> findAllByUserId(T user_id);
}
