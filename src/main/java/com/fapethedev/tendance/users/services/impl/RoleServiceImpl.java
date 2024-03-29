package com.fapethedev.tendance.users.services.impl;

import com.fapethedev.tendance.users.entities.Role;
import com.fapethedev.tendance.users.repositories.RoleRepository;
import com.fapethedev.tendance.users.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService
{
    private final RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return repository.findRoleByName(name);
    }
}
