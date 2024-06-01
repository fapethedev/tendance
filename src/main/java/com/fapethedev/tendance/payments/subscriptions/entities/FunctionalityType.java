package com.fapethedev.tendance.payments.subscriptions.entities;

/**
 * <p>The type of a functionality.
 * A functionality has a type within a fixed range.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
public enum FunctionalityType
{
    /**
     * <p>The functionality is free to use and
     * don't need any type of subscription.</p>
     */
    FREE,

    /**
     * <p>The functionality is free but his usage is limited.
     * The user may be need to made a subscription to continue
     * to use it.</p>
     */
    FREEMIUM,

    /**
     * <p>The functionality need a subscription to be use.</p>
     */
    PREMIUM
}
