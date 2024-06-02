package com.fapethedev.tendance.payments.subscriptions.services;

import com.fapethedev.tendance.payments.subscriptions.entities.Subscription;
import com.fapethedev.tendance.payments.subscriptions.form.SubscriptionForm;
import com.fapethedev.tendance.payments.subscriptions.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>The concrete service class layer for subscription service layer.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 * @see com.fapethedev.tendance.payments.subscriptions.services.ISubscriptionService
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionService implements ISubscriptionService
{
    /**
     * <p>The subscription repository.</p>
     */
    private final SubscriptionRepository repository;

    @Override
    public Subscription save(Subscription subscription)
    {
        log.info("Saving subscription");

        return repository.save(subscription);
    }

    @Override
    public Subscription save(SubscriptionForm form)
    {
        log.info("Saving subscription with form");

        return save(
                Subscription.builder()
                        .startDateTime(form.getStartDateTime())
                        .endDateTime(form.getEndDateTime())
                        .cost(form.getCost())
                        .duration(form.getDuration())
                        .currency(form.getCurrency())
                        .plan(form.getPlan())
                        .subscriber(form.getSubscriber())
                        .build()
        );
    }

    @Override
    public Subscription delete(Subscription subscription)
    {
        log.info("Deleting subscription: " + subscription.getId());

        repository.delete(subscription);

        return subscription;
    }

    @Override
    public Subscription deleteById(UUID uuid)
    {
        log.info("Deleting subscription with id: " + uuid);

        return delete(findById(uuid));
    }

    @Override
    public Subscription findById(UUID uuid)
    {
        log.info("Finding subscription with id: " + uuid);

        return repository.findById(uuid).orElseThrow();
    }

    @Override
    public List<Subscription> findAll()
    {
        log.info("Finding all subscriptions");

        return repository.findAll();
    }
}
