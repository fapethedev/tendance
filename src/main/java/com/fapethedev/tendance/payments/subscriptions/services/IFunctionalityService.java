package com.fapethedev.tendance.payments.subscriptions.services;

import com.fapethedev.tendance.main.services.IService;
import com.fapethedev.tendance.payments.subscriptions.entities.Functionality;
import com.fapethedev.tendance.payments.subscriptions.form.FunctionalityForm;

import java.util.UUID;

/**
 * <p>Service layer interface for functionality.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
public interface IFunctionalityService extends IService<Functionality, UUID, FunctionalityForm> {
}
