package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.users.entities.*;
import com.fapethedev.tendance.users.exceptions.UserNotFoundException;
import com.fapethedev.tendance.users.form.UserForm;
import com.fapethedev.tendance.users.repositories.AccountRepository;
import com.fapethedev.tendance.users.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The implementation of the {@link IUserService}
 * @author Fapethedev
 * @since 1.0
 * @see com.fapethedev.tendance.users.services.IUserService
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements IUserService
{
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final IRoleService IRoleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(UserForm userForm)
    {
        User user = User.builder()
                .identity(UserIdentity
                        .builder()
                        .lastname(userForm.getLastname())
                        .firstname(userForm.getFirstname())
                        .email(userForm.getEmail())
                        .build())
                .adress(UserAdress
                        .builder()
                        .phone(userForm.getPhone())
                        .city(userForm.getCity())
                        .country(userForm.getCountry())
                        .build())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .build();

        Optional<Role> roleOptional = IRoleService.findByName(Role.Category.ROLE_STANDARD.name());

        Role role = roleOptional.orElseGet(this::setDefaultRole);

        user.setRoles(Collections.singletonList(role));

        user.setType(User.UserType.STANDARD);

        user = userRepository.save(user);

        Account account = Account.builder()
                .user(user)
                .build();

        accountRepository.save(account);

        user.setAccount(account);

        return user;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public User deleteById(UUID uuid) {
        return null;
    }

    @Override
    public User save(User user)
    {
        User nUser = userRepository.save(user);

        accountRepository.save(nUser.getAccount());

        return nUser;
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
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("No user with the given email is found"));
    }

    @Override
    public List<User> findAll() {
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
        return IRoleService.save(role);
    }
}
