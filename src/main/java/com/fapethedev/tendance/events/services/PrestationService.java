package com.fapethedev.tendance.events.services;


import com.fapethedev.tendance.events.entities.Prestation;
import com.fapethedev.tendance.events.form.PrestationForm;
import com.fapethedev.tendance.events.repository.PrestationRepository;
import com.fapethedev.tendance.main.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * {@code PrestationService} an implementation of {@link IPrestationService}
 * @author Fapethedev
 * @since 1.0
 * @see com.fapethedev.tendance.events.services.IPrestationService
 * @see com.fapethedev.tendance.main.services.IService
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PrestationService implements IPrestationService
{
    private final PrestationRepository prestationRepository;

    @Override
    public Prestation save(Prestation prestation)
    {
        log.info("Creating new Prestation");

        return prestationRepository.save(prestation);
    }

    @Override
    public Prestation save(PrestationForm prestationForm)
    {
        log.info("Creating new Prestation with PrestationForm");

        var prestation = new Prestation(prestationForm.getStartDateTime(),
                prestationForm.getEndDateTime(),
                prestationForm.getUser(),
                prestationForm.getEvent(),
                prestationForm.getServiceEvent());

        return prestationRepository.save(prestation);
    }

    @Override
    public Prestation delete(Prestation prestation)
    {
        log.info("Deleting prestation : " + prestation.getId());

        prestationRepository.delete(prestation);
        return prestation;
    }

    @Override
    public Prestation deleteById(UUID uuid)
    {
        log.info("Deleting Prestation with the id : " + uuid);

        return delete(findById(uuid));
    }

    @Override
    public Prestation findById(UUID uuid)
    {
        log.info("Finding Prestation with the id : " + uuid);

        return prestationRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("No Prestation with the given id : " + uuid));
    }

    @Override
    public List<Prestation> findAll() {
        log.info("Finding all prestations...");

        return prestationRepository.findAll();
    }
}
