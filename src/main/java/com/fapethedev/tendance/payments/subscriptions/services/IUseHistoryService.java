package com.fapethedev.tendance.payments.subscriptions.services;

import com.fapethedev.tendance.payments.subscriptions.entities.UseHistory;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

/**
 * <p>Service layer interface for use history.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
public interface IUseHistoryService
{
    /**
     * <p>Save or update a use history.</p>
     *
     * @param history the use history
     *
     * @return UseHistory from a database
     */
    UseHistory save (UseHistory history);

    /**
     * <p>Find a functionality use history from his id.</p>
     *
     * @param id the use history id
     *
     * @return UseHistory with the given id
     *
     * @throws jakarta.persistence.EntityNotFoundException
     * if no functionality use history has the given id
     */
    UseHistory findById(UUID id) throws EntityNotFoundException;

    /**
     * <p>Get all the functionality use histories from the database.</p>
     *
     * @return All the functionality use histories
     */
    List<UseHistory> findAll();

    /**
     * <p>Get a user all functionality use histories</p>
     *
     * @return All the functionality use histories for the specified user
     */
    List<UseHistory> getHistoriesByUserId(UUID userId);
}
