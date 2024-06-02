package com.fapethedev.tendance.payments.subscriptions.services;

import com.fapethedev.tendance.payments.subscriptions.entities.UseHistory;
import com.fapethedev.tendance.payments.subscriptions.repository.UseHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>The concrete service class layer for use history service layer.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 * @see com.fapethedev.tendance.payments.subscriptions.services.IUseHistoryService
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UseHistoryService implements IUseHistoryService
{
    /**
     * <p>The use history repository.</p>
     */
    private final UseHistoryRepository<UUID> repository;

    @Override
    public UseHistory save(UseHistory useHistory)
    {
        log.info("Saving use history");

        return repository.save(useHistory);
    }
    @Override
    public UseHistory findById(UUID uuid)
    {
        log.info("Finding use history with id: " + uuid);

        return repository.findById(uuid).orElseThrow();
    }

    @Override
    public List<UseHistory> findAll()
    {
        log.info("Finding all use histories");

        return repository.findAll();
    }

    @Override
    public List<UseHistory> getHistoriesByUserId(UUID userId)
    {
        log.info("Finding all use histories by user id: " + userId);

        return repository.findAllByUserId(userId);
    }
}
