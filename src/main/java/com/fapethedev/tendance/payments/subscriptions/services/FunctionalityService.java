package com.fapethedev.tendance.payments.subscriptions.services;

import com.fapethedev.tendance.payments.subscriptions.entities.Functionality;
import com.fapethedev.tendance.payments.subscriptions.form.FunctionalityForm;
import com.fapethedev.tendance.payments.subscriptions.repository.FunctionalityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>The concretes service class for functionality service layer.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 * @see com.fapethedev.tendance.payments.subscriptions.services.IFunctionalityService
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FunctionalityService implements IFunctionalityService
{
    /**
     * <p>The functionality repository.</p>
     */
    private final FunctionalityRepository repository;

    @Override
    public Functionality save(Functionality functionality)
    {
        log.info("Saving functionality");

        return repository.save(functionality);
    }

    @Override
    public Functionality save(FunctionalityForm form)
    {
        log.info("Saving functionality with form");

        return repository.save(
                new Functionality(
                        form.getDesignation(),
                        form.getDescription(),
                        form.getType()
                )
        );
    }

    @Override
    public Functionality delete(Functionality functionality)
    {
        log.info("Deleting functionality: " + functionality.getId());

        repository.delete(functionality);

        return functionality;
    }

    @Override
    public Functionality deleteById(UUID uuid)
    {
        log.info("Deleting functionality with id: " + uuid);

        return delete(findById(uuid));
    }

    @Override
    public Functionality findById(UUID uuid)
    {
        log.info("Finding functionality with id: " + uuid);

        return repository.findById(uuid).orElseThrow();
    }

    @Override
    public List<Functionality> findAll()
    {
        log.info("Finding all functionalities");

        return repository.findAll();
    }
}
