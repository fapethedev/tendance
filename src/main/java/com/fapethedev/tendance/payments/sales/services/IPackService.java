package com.fapethedev.tendance.payments.sales.services;

import com.fapethedev.tendance.main.services.IService;
import com.fapethedev.tendance.payments.sales.entities.PassPack;
import com.fapethedev.tendance.payments.sales.form.PackForm;

import java.util.UUID;

/**
 * <p>Service layer interface for pack of ticket.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
public interface IPackService extends IService<PassPack, UUID, PackForm> {
}
