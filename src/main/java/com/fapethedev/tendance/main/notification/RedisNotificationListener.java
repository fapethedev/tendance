package com.fapethedev.tendance.main.notification;

import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>Component listener class for persist
 *  * notification event on redis store.</p>
 *
 * @see com.fapethedev.tendance.main.notification.NotificationListener
 * @see MySQLNotificationListener
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Component(value = "redis_notif_lstnr")
public class RedisNotificationListener implements NotificationListener
{
    private RedisTemplate<String, Object> redisTemplate;

    @EventListener
    @Override
    public void onNotification(NotificationEvent event) {
        redisTemplate.opsForValue().set(
                event.getUser().getUsername() + "notif",
                event.getNotification()
        );
    }
}
