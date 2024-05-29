package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.Delivery;
import com.fapethedev.tendance.events.form.DeliveryForm;
import com.fapethedev.tendance.main.services.IService;

import java.util.UUID;

/**
 * <p>Service layer interface for working with {@code Delivery}
 * and {@code DeliveryForm}.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public interface IDeliveryService extends IService<Delivery, UUID, DeliveryForm> {
}
