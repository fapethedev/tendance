package com.fapethedev.tendance.payments.subscriptions.services;


import com.fapethedev.tendance.main.services.IService;
import com.fapethedev.tendance.payments.subscriptions.entities.Subscription;
import com.fapethedev.tendance.payments.subscriptions.form.SubscriptionForm;

import java.util.UUID;

/**
 * <p>Service layer interface for subscription.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
public interface ISubscriptionService extends IService<Subscription, UUID, SubscriptionForm> {
}
