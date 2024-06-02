package com.fapethedev.tendance.payments.sales.services;

import com.fapethedev.tendance.payments.sales.entities.Pass;
import com.fapethedev.tendance.payments.sales.form.PassForm;
import com.fapethedev.tendance.payments.sales.repository.PassRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>The service layer class for ticket.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 * @see com.fapethedev.tendance.payments.sales.services.IPassService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PassService implements IPassService
{
    /**
     * <p>The ticket repository.</p>
     */
    private final PassRepository repository;

    @Override
    public Pass save(Pass pass)
    {
        log.info("Saving ticket");

        return repository.save(pass);
    }

    @Override
    public Pass save(PassForm form)
    {
        log.info("Saving ticket with form");

        return repository.save(
                Pass.builder()
                        .logo(form.getLogo())
                        .price(form.getPrice())
                        .currency(form.getCurrency())
                        .stock(form.getStock())
                        .passState(form.getPassState())
                        .passType(form.getPassType())
                        .event(form.getEvent())
                        .build()
        );
    }

    @Override
    public Pass delete(Pass pass)
    {
        log.info("Deleting pass");

        repository.delete(pass);

        return pass;
    }

    @Override
    public Pass deleteById(UUID uuid)
    {
        log.info("Deleting pass with id: " + uuid);

        return delete(findById(uuid));
    }

    @Override
    public Pass findById(UUID uuid)
    {
        log.info("Finding pass with id: " + uuid);

        return repository.findById(uuid).orElseThrow();
    }

    @Override
    public List<Pass> findAll()
    {
        log.info("Finding all tickets");

        return repository.findAll();
    }
}
