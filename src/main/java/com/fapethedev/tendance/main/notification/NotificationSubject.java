package com.fapethedev.tendance.main.notification;

/**
 * <p>Subject interface class for dealing with notification observer.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
public interface NotificationSubject
{
    /**
     * <p>Register a new observer for notifications.</p>
     *
     * @param observer the notification observer to add
     */
    void registerObserver(NotificationObserver observer);

    /**
     * <p>Remove an observer from observers list.</p>
     *
     * @param observer the notification observer to remove
     */
    void removeObserver(NotificationObserver observer);

    /**
     * <p>Notify all observers that's a new notification has come.</p>
     *
     * @param notification the notification entity
     */
    void notifyObservers(NotificationEntity notification);
}
