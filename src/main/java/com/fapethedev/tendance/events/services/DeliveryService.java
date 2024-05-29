package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.Delivery;
import com.fapethedev.tendance.events.form.DeliveryForm;
import com.fapethedev.tendance.events.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>Service implementations of {@code IDeliveryService}</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 * @see com.fapethedev.tendance.events.services.IDeliveryService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DeliveryService implements IDeliveryService
{
    /**
     * <p>Repository that's serve for database layer for {@code Delivery}.</p>
     */
    private final DeliveryRepository deliveryRepository;

    @Override
    public Delivery save(Delivery delivery)
    {
        log.info("Saving delivery");

        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery save(DeliveryForm deliveryForm)
    {
        log.info("Saving delivery from form");

        return deliveryRepository.save(
                Delivery.builder()
                        .name(deliveryForm.getName())
                        .description(deliveryForm.getDescription())
                        .price(deliveryForm.getPrice())
                        .currency(deliveryForm.getCurrency())
                        .poster(deliveryForm.getPoster())
                        .user(deliveryForm.getUser())
                        .build()
        );
    }

    @Override
    public Delivery delete(Delivery delivery)
    {
        log.info("Deleting delivery");

        deliveryRepository.delete(delivery);

        return delivery;
    }

    @Override
    public Delivery deleteById(UUID uuid)
    {
        log.info("Deleling delivery with id " + uuid);

        return delete(findById(uuid));
    }

    @Override
    public Delivery findById(UUID uuid)
    {
        log.info("Finding delivery with id " + uuid);

        return deliveryRepository.findById(uuid)
                .orElseThrow();
    }

    @Override
    public List<Delivery> findAll()
    {
        log.info("Finding all deliveries");

        return deliveryRepository.findAll();
    }
}
