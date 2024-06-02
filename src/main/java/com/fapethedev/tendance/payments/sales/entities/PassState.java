package com.fapethedev.tendance.payments.sales.entities;

/**
 * <p>The state of a pass, determines if a pass is available or not.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public enum PassState
{
    /**
     * <p>The pass is not available for sales.</p>
     */
    UNAVAILABLE,

    /**
     * <p>The pass is available for sales.</p>
     */
    AVAILABLE,

    /**
     * <p>The quantity of pass is used.</p>
     */
    OUT_OF_STOCK
}
