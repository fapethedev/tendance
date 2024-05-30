package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.PrestationRequest;
import com.fapethedev.tendance.events.form.PrestationRequestForm;
import com.fapethedev.tendance.main.services.IService;

import java.util.UUID;

/**
 * Service Layer for {@code IPrestationRequestService}
 *
 * @see com.fapethedev.tendance.main.services.IService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public interface IPrestationRequestService extends IService<PrestationRequest, UUID, PrestationRequestForm> {
}
