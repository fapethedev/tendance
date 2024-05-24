package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.users.entities.Role;

/**
 * <p>Role service interface.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
public interface IRoleService
{
    /**
     * <p>Save a new role for user as roles are intended for authorities.</p>
     *
     * @param role the user role
     * @return the newly created role
     */
    Role save(Role role);

    /**
     * <p>Try to find a role with the corresponding name if the role
     * is not found although throws an exception, the default role
     * will be find and return.</p>
     * <p>If there no default role a new one should be created and returned.
     * This behavior is due to the necessity af an available role any ways.</p>
     *
     * @param name the name of the role given the role category
     * @return the role with the given
     */
    Role findByName(String name);
}
