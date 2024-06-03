package com.fapethedev.tendance.main.notification;

/**
 * <p>Observer interface class for notification in the application.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
public interface NotificationObserver
{
    /**
     * <p>Notify that a new notification is listen.</p>
     *
     * @param message the notification message
     */
    void receiveNotificationMessage(NotificationEntity message);
}
