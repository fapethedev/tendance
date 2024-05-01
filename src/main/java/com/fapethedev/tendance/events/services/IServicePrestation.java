package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.Prestation;
import com.fapethedev.tendance.events.form.PrestationForm;
import com.fapethedev.tendance.main.services.IService;

import java.util.UUID;

/**
 * Service Layer for {@code Prestation}
 * @author Fapethedev
 * @since 1.0
 * @see com.fapethedev.tendance.main.services.IService
 */
public interface IServicePrestation extends IService<Prestation, UUID, PrestationForm> {
}
