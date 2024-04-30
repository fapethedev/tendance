package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.form.UserForm;

import java.util.List;
import java.util.UUID;

public interface UserService
{
    User save(UserForm user);

    User saveOrUpdate(User user);

    User delete(UserForm user);

    User findById(UUID id);

    User findUserByEmail(String email);

    boolean existByEmail(String email);

    List<User> findAllUsers();
}
