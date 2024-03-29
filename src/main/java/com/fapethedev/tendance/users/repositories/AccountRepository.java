package com.fapethedev.tendance.users.repositories;

import com.fapethedev.tendance.users.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID>
{

}
