package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.users.dto.UserDto;
import com.fapethedev.tendance.users.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserService
{
    User save(UserDto user);

    User saveOrUpdate(User user);

    User delete(UserDto user);

    User findById(UUID id);

    User findUserByEmail(String email);

    List<User> findAllUsers();
}
