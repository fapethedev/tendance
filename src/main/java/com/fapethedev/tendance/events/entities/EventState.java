package com.fapethedev.tendance.events.entities;


/**
 * Enumeration that represents the six different of an event
 * from pending to end
 * @author Fapethedev
 * @since 1.0
 */
public enum EventState
{
    /**
     * The event is published and has not started. <br/>
     * Everyone can see it and buy a ticket if allow
     */
    PUBLISHED,

    /**
     * The event is published and has started
     */
    LIVE,

    /**
     * The event is published and has ended
     */
    END,

    /**
     * The event is published and has been aborted
     */
    ABORT,

    /**
     * The event is published and has been postponed for a further date
     */
    POSTPONED,

    /**
     * The event is created but not published it's only seen by the organizer
     */
    PENDING
}