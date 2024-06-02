package com.fapethedev.tendance.payments.sales.services;

import com.fapethedev.tendance.main.services.IService;
import com.fapethedev.tendance.payments.sales.entities.Pass;
import com.fapethedev.tendance.payments.sales.form.PassForm;

import java.util.UUID;

/**
 * <p>Service layer interface for ticket.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
public interface IPassService extends IService<Pass, UUID, PassForm> {
}
