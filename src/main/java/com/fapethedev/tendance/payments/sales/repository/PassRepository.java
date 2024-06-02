package com.fapethedev.tendance.payments.sales.repository;

import com.fapethedev.tendance.payments.sales.entities.Pass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * <p>Database layer interface for Ticket</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Repository
public interface PassRepository extends JpaRepository<Pass, UUID> {
}
