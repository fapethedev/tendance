package com.fapethedev.tendance.users.repositories;

import com.fapethedev.tendance.users.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID>
{

    Optional<Role> findRoleByName(String name);
}
