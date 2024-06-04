package com.fapethedev.tendance.users.repositories;

import com.fapethedev.tendance.users.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * <p>The database layer interface class for crud operations on {@code Role}
 * entity in the application.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public interface RoleRepository extends JpaRepository<Role, UUID>
{
    /**
     * <p>Find a role using his name. Role name are unique.</p>
     *
     * @param name the name of the role
     *
     * @return optional of the role
     */
    Optional<Role> findRoleByName(String name);
}
