package com.fapethedev.tendance.main.notification;


/**
 * <p>Listener interface class for listening all
 * notification events.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
public interface NotificationListener
{
    /**
     * <p>The listener method for handling a new notification event for user
     * with inside the associated notification entity.</p>
     *
     * @param event the notification event
     */
    void onNotification(NotificationEvent event);
}
