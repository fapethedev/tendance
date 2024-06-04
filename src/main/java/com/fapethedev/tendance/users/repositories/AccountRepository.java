package com.fapethedev.tendance.users.repositories;

import com.fapethedev.tendance.users.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * <p>The database layer interface class for account entity.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
}
