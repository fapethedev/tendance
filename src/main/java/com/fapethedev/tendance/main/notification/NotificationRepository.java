package com.fapethedev.tendance.main.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * <p>Notification entity database layer interface class for
 * crud operations.</p>
 *
 * @author <a href="www.github.com/fapethedev/">Fapethedev</a>
 * @version 1.0
 */
@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, UUID> {
}
