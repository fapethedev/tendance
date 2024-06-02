package com.fapethedev.tendance.payments.subscriptions.services;

import com.fapethedev.tendance.main.services.IService;
import com.fapethedev.tendance.payments.subscriptions.entities.SubscriptionPlan;
import com.fapethedev.tendance.payments.subscriptions.form.SubscriptionPlanForm;

import java.util.UUID;

/**
 * <p>Service layer interface for subscription plan.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
public interface ISubscriptionPlanService extends IService<SubscriptionPlan, UUID, SubscriptionPlanForm> {
}
