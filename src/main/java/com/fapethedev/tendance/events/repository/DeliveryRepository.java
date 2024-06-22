package com.fapethedev.tendance.events.repository;

import com.fapethedev.tendance.events.entities.Delivery;
import com.fapethedev.tendance.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * {@code DeliveryRepository} is an interface for querying {@link Delivery}
 * table from the database using {@code JpaRepository} methods
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 *
 */
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {
    List<Delivery> findAllByUser(User user);
}
