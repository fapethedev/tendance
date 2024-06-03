package com.fapethedev.tendance.security.manager;

import com.fapethedev.tendance.security.facade.AuthenticationFacade;
import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>Login manager class service.</p>
 *
 * @author Fapethedev
 * @version 1.0
 */
@Slf4j
@Service
public class UserLoginManager implements UserDetailsManager, UserDetailsPasswordService
{
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationFacade facade;

    @Autowired
    public UserLoginManager(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationFacade facade) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.facade = facade;
    }

    @Override
    public void createUser(UserDetails user)
    {
        log.info("Creating user");

        userRepository.save((User) user);
    }

    @Override
    public void updateUser(UserDetails user)
    {
        log.warn("User update");

        userRepository.save((User) user);
    }

    @Override
    public void deleteUser(String username)
    {
        log.warn("Try to delete user : " + username);
        if (userExists(username))
        {
            userRepository.deleteByUsername(username);
        }
    }

    @Override
    public void changePassword(String oldPassword, String newPassword)
    {
        Authentication authentication = facade.getAuthentication();

        if (authentication == null)
            throw new AccessDeniedException("Cannot change password for non authenticated user");

        String username = authentication.getName();

        log.warn("Updating user : " + username + " password");

        User updatedUser = userRepository.findByEmail(username)
                .orElseThrow( () -> new UsernameNotFoundException("User : " + username + " not found"));

        updatedUser.setPassword(passwordEncoder.encode(newPassword));

        updateUser(updatedUser);
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword)
    {
        log.warn("Updating user : " + user.getUsername() + " password");

        User updatedUser = userRepository.findByEmail(user.getUsername())
                .orElseThrow( () -> new UsernameNotFoundException("User : " + user.getUsername() + " not found"));

        updatedUser.setPassword(passwordEncoder.encode(newPassword));

        updateUser(updatedUser);

        return updatedUser;
    }

    @Override
    public boolean userExists(String username)
    {
        return userRepository.countByEmail(username) > 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        log.info("Loading user by username : " + username);

        return userRepository.findByEmail(username).orElseThrow();
    }

    /**
     * <p>Creates a strong password using secure random
     * and encode it's with the available password encoder.</p>
     *
     * @return the random password with the right encoding
     */
    public static String generateRandomPassword()
    {
        return UUID.randomUUID().toString();
    }
}
