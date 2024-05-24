package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.users.entities.Role;
import com.fapethedev.tendance.users.repositories.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>IRoleService default implementation.</p>
 *
 * @see com.fapethedev.tendance.users.services.IRoleService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
@Slf4j
public class RoleService implements IRoleService
{
    private final RoleRepository repository;

    @Autowired
    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role save(Role role)
    {
        log.info("Saving role " + role.getName());

        return repository.save(role);
    }

    @Override
    public Role findByName(String name)
    {
        log.info("Finding role by name: " + name);

        return repository.findRoleByName(name).orElseGet(() ->
        {
            log.warn("Role with name " + name + " not found");
            log.warn("'Finding the default role");

            return repository.findRoleByName(Role.Category.ROLE_STANDARD.name())
                    .orElseGet(() -> {
                        log.warn("Default role not find");
                        log.warn("Creating default role");

                        return save(new Role(Role.Category.ROLE_STANDARD));
                    });
        });
    }
}
