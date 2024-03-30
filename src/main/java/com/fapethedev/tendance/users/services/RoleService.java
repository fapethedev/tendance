package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.users.entities.Role;

import java.util.Optional;

public interface RoleService
{
    Role save(Role role);

    Optional<Role> findByName(String name);
}