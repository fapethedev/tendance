package com.fapethedev.tendance.main.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * <p>Component listener class for persist
 * notification event on mysql database.</p>
 *
 * @see com.fapethedev.tendance.main.notification.NotificationListener
 * @see com.fapethedev.tendance.main.notification.RedisNotificationListener
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Component(value = "mysql_notif_lstnr")
@RequiredArgsConstructor
public class MySQLNotificationListener implements NotificationListener
{
    /**
     * <p>Database layer for notification.</p>
     */
    private final NotificationRepository repository;

    @Override
    @EventListener
    public void onNotification(NotificationEvent event) {
        repository.save(event.getNotification());
    }
}
