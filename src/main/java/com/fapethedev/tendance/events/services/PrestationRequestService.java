package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.PrestationRequest;
import com.fapethedev.tendance.events.form.PrestationRequestForm;
import com.fapethedev.tendance.events.repository.PrestationRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>Prestation Request Service that's implements
 * {@link IPrestationRequestService}.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 * @see com.fapethedev.tendance.events.services.IPrestationRequestService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PrestationRequestService implements IPrestationRequestService
{
    /**
     * <p>Prestation request repository.</p>
     */
    private final PrestationRequestRepository repository;

    @Override
    public PrestationRequest save(PrestationRequest request)
    {
        log.info("Saving Prestation Request");

        return repository.save(request);
    }

    @Override
    public PrestationRequest save(PrestationRequestForm form)
    {
        log.info("Saving Prestation Request with form");

        return repository.save(
                PrestationRequest.builder()
                        .message(form.getMessage())
                        .status(form.getStatus())
                        .startDateTime(form.getStartDateTime())
                        .endDateTime(form.getEndDateTime())
                        .event(form.getEvent())
                        .delivery(form.getDelivery())
                        .sender(form.getSender())
                        .receiver(form.getReceiver())
                        .build()
        );
    }

    @Override
    public PrestationRequest delete(PrestationRequest request)
    {
        log.info("Deleting Prestation Request " + request.getId());

        repository.delete(request);

        return request;
    }

    @Override
    public PrestationRequest deleteById(UUID uuid)
    {
        log.info("Deleting Prestation Request with id: " + uuid);

        return delete(findById(uuid));
    }

    @Override
    public PrestationRequest findById(UUID uuid)
    {
        log.info("Finding Prestation Request with id: " + uuid);

        return repository.findById(uuid).orElseThrow();
    }

    @Override
    public List<PrestationRequest> findAll()
    {
        log.info("Finding all requests");

        return repository.findAll();
    }
}
