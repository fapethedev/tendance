package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.Prestation;
import com.fapethedev.tendance.events.entities.PrestationRequest;
import com.fapethedev.tendance.events.form.PrestationForm;
import com.fapethedev.tendance.main.services.IService;

import java.util.UUID;

/**
 * <p>Service layer interface for {@code Prestation}.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public interface IPrestationService extends IService<Prestation, UUID, PrestationForm>
{
    /**
     * <p>Creates a new prestation from an accepted prestation request.</p>
     *
     * @param request the prestation request with the status accepted
     * @return a valid prestation
     */
    Prestation createPrestationFromRequest(PrestationRequest request);
}
