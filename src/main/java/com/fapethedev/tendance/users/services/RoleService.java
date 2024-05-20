package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.users.entities.Role;
import com.fapethedev.tendance.users.repositories.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return repository.findRoleByName(name);
    }
}
