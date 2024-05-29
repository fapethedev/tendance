package com.fapethedev.tendance.events.services;


import com.fapethedev.tendance.events.entities.Prestation;
import com.fapethedev.tendance.events.entities.PrestationRequest;
import com.fapethedev.tendance.events.form.PrestationForm;
import com.fapethedev.tendance.events.repository.PrestationRepository;
import com.fapethedev.tendance.users.entities.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>{@code PrestationService} an implementation of
 * {@link IPrestationService}.</p>
 *
 * @see com.fapethedev.tendance.events.services.IPrestationService
 * @see com.fapethedev.tendance.main.services.IService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PrestationService implements IPrestationService
{
    /**
     * <p>Prestation repository.</p>
     */
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

        return prestationRepository.save(
                new Prestation(
                        prestationForm.getDescription(),
                        prestationForm.getStartDateTime(),
                        prestationForm.getEndDateTime(),
                        prestationForm.getEvent(),
                        prestationForm.getDelivery(),
                        prestationForm.getEventUser(),
                        prestationForm.getDeliveryUser()
                )
        );
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

    @Override
    public Prestation createPrestationFromRequest(PrestationRequest request)
    {
        log.info("Creating prestation from request " + request.getId());
        
        var eventUser = request.getReceiver().getType() == User.Type.ORGANIZER ?
                request.getReceiver() : request.getSender();

        var deliveryUser = request.getReceiver().getType() != User.Type.ORGANIZER ?
                request.getReceiver() : request.getSender();

        return save(
                new Prestation(
                        request.getMessage(),
                        request.getStartDateTime(),
                        request.getEndDateTime(),
                        request.getEvent(),
                        request.getDelivery(),
                        eventUser,
                        deliveryUser
                )
        );
    }
}
