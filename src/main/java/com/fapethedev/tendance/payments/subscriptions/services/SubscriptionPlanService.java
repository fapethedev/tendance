package com.fapethedev.tendance.payments.subscriptions.services;

import com.fapethedev.tendance.payments.subscriptions.entities.SubscriptionPlan;
import com.fapethedev.tendance.payments.subscriptions.form.SubscriptionPlanForm;
import com.fapethedev.tendance.payments.subscriptions.repository.SubscriptionPlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>The concrete service class layer for subscription plan service layer.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 * @see com.fapethedev.tendance.payments.subscriptions.services.ISubscriptionPlanService
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionPlanService implements ISubscriptionPlanService
{
    /**
     * <p>The subscription plan repository.</p>
     */
    private final SubscriptionPlanRepository repository;

    @Override
    public SubscriptionPlan save(SubscriptionPlan plan)
    {
        log.info("Saving subscription plan");

        return repository.save(plan);
    }

    @Override
    public SubscriptionPlan save(SubscriptionPlanForm form) 
    {
        log.info("Saving subscription plan with form");

        return save(
                new SubscriptionPlan(
                        form.getTitle(),
                        form.getContent(),
                        form.getPrice(),
                        form.getIsAvailable(),
                        form.getFunctionalities()
                )
        );
    }
    
    @Override
    public SubscriptionPlan delete(SubscriptionPlan plan)
    {
        log.info("Deleting subscription plan: " + plan.getId());

        repository.delete(plan);

        return plan;
    }

    @Override
    public SubscriptionPlan deleteById(UUID uuid)
    {
        log.info("Deleting subscription plan with id: " + uuid);

        return delete(findById(uuid));
    }

    @Override
    public SubscriptionPlan findById(UUID uuid)
    {
        log.info("Finding subscription plan with id: " + uuid);

        return repository.findById(uuid).orElseThrow();
    }

    @Override
    public List<SubscriptionPlan> findAll()
    {
        log.info("Finding all subscription plans");

        return repository.findAll();
    }
}
