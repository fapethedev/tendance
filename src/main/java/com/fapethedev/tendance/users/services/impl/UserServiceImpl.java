package com.fapethedev.tendance.users.services.impl;

import com.fapethedev.tendance.users.dto.UserDto;
import com.fapethedev.tendance.users.entities.*;
import com.fapethedev.tendance.users.exceptions.UserNotFoundException;
import com.fapethedev.tendance.users.repositories.AccountRepository;
import com.fapethedev.tendance.users.repositories.UserRepository;
import com.fapethedev.tendance.users.services.RoleService;
import com.fapethedev.tendance.users.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService
{
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(AccountRepository accountRepository, UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(UserDto user)
    {
        User nUser = User.builder()
                .identity(UserIdentity
                        .builder()
                        .lastname(user.getLastname())
                        .firstname(user.getFirstname())
                        .email(user.getEmail())
                        .build())
                .adress(UserAdress
                        .builder()
                        .phone(user.getPhone())
                        .city(user.getCity())
                        .country(user.getCity())
                        .build())
                .password(passwordEncoder.encode(user.getPassword()))
                .build();

        Optional<Role> roleOptional = roleService.findByName(Role.Category.ROLE_STANDARD.name());

        Role role = roleOptional.orElseGet(this::setDefaultRole);

        nUser.setRoles(Collections.singletonList(role));

        nUser = userRepository.save(nUser);

        Account account = Account.builder()
                .user(nUser)
                .build();

        accountRepository.save(account);

        nUser.setAccount(account);

        return nUser;
    }

    @Override
    public User saveOrUpdate(User user)
    {
        User nUser = userRepository.save(user);

        accountRepository.save(nUser.getAccount());

        return nUser;
    }

    @Override
    public User delete(UserDto user)
    {
        return null;
    }

    @Override
    public User findById(UUID id)
    {
        Optional<User> userOptional = userRepository.findById(id);

        return userOptional.orElseThrow(() -> new UserNotFoundException("User with " + id + " does not exist"));
    }

    @Override
    public User findUserByEmail(String email)
    {
        Optional<User> userOptional = userRepository.findByEmail(email);

        return userOptional.orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.countByEmail(email) > 0;
    }

    private Role setDefaultRole()
    {
        Role role = new Role();
        role.setName(Role.Category.ROLE_STANDARD.name());
        return roleService.save(role);
    }
}
