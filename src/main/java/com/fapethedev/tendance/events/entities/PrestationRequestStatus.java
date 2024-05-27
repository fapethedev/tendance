package com.fapethedev.tendance.events.entities;

/**
 * <p>Defines the state of a PrestationRequest which is sending
 * by a non standard user (admin and visitor are exclude)
 * to another user like himself.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public enum PrestationRequestStatus
{
    /**
     * <p>The request is recently and is not answered yet
     * or is ignored.</p>
     */
    PENDING,

    /**
     * <p>The request is accept by the receiver.
     * A the concerned prestation will be associated
     * to the designed event.</p>
     */
    ACCEPTED,

    /**
     * <p>The receiver reject the request as simple as it sound.</p>
     */
    REJECTED,

    /**
     * <p>The user that send the request decides to step back
     * in the process before is accepted or rejected so he aborts the request.</p>
     */
    ABORT
}
