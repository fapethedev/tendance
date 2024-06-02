package com.fapethedev.tendance.payments.sales.repository;

import com.fapethedev.tendance.payments.sales.entities.PassPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * <p>Database layer interface for pack of tickets.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Repository
public interface PackRepository extends JpaRepository<PassPack, UUID> {
}
