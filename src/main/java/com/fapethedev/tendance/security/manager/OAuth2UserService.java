package com.fapethedev.tendance.security.manager;

import com.fapethedev.tendance.users.entities.Account;
import com.fapethedev.tendance.users.entities.Role;
import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.entities.UserIdentity;
import com.fapethedev.tendance.users.entities.oauth2.OAuth2AbstractUser;
import com.fapethedev.tendance.users.entities.oauth2.OAuth2UserDetails;
import com.fapethedev.tendance.users.entities.oauth2.OAuth2UserFactory;
import com.fapethedev.tendance.users.exceptions.UserNotFoundException;
import com.fapethedev.tendance.users.services.AccountService;
import com.fapethedev.tendance.users.services.IRoleService;
import com.fapethedev.tendance.users.services.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collections;

/**
 * <p>This is the service layer class for login or register user
 * that intent to use oath2 for login or registration.</p>
 *
 * @see org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
 * @see org.springframework.security.oauth2.client.userinfo.OAuth2UserService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OAuth2UserService extends DefaultOAuth2UserService
{
    private final IUserService userService;

    private final IRoleService roleService;

    private final AccountService accountService;

    private final PasswordEncoder passwordEncoder;

    /**
     * <p>Gets a custom {@code OAuth2User} by overriding the {@code DefaultOauth2UserService}
     * instead of returning the default oauth2, the method will build and return
     * {@code OAuth2UserDetails} after use the {@code OAuth2UserFactory} to get
     * a {@code OAuth2AbstractUser} which is used to query the database for retrieving
     * the user and optionally register him in the database if he's not found.</p>
     *
     * @param userRequest the oauth2 request that came from the oauth2 provider
     *
     * @return the user that login or register with oauth2
     *
     * @throws OAuth2AuthenticationException if an error occurs
     */
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException
    {
        var oAuth2User = super.loadUser(userRequest);

        try
        {
            return processOAuth2User(userRequest, oAuth2User);
        }
        catch (AuthenticationException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            throw new InternalAuthenticationServiceException(e.getMessage(), e.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest request, OAuth2User oAuth2User)
    {
        var provider = request.getClientRegistration().getRegistrationId();
        var abstractUser = OAuth2UserFactory.getOAuth2User(provider, oAuth2User.getAttributes());
        if (ObjectUtils.isEmpty(abstractUser)) throw new IllegalStateException();

        User user;
        var email = abstractUser.getEmail();

        try
        {
            user = userService.findUserByEmail(email);

            var account = user.getAccount();

            if (!user.isEnabled())
            {
                user.setProvider(provider);
                user = userService.save(user);

                account.setActive(true);
                account.setEmailVerified(true);
                account = accountService.save(account);

                user.setAccount(account);
            }

            if (account.getPicture() == null || account.getPicture().isEmpty())
            {
                account.setPicture(abstractUser.getProfile());
                account = accountService.save(account);
                user.setAccount(account);
            }
        }
        catch (UserNotFoundException e)
        {
            log.warn(e.getMessage());

            log.info("Register OAuth2User : username = " + email);

            user = registerNewOAuth2User(request, abstractUser);
        }

        return new OAuth2UserDetails(user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getAccount(),
                user.getAuthorities()
        );
    }

    private User registerNewOAuth2User(OAuth2UserRequest request, OAuth2AbstractUser abstractUser)
    {
        var user = userService.save(
                User.builder()
                        .identity(
                                UserIdentity.builder()
                                        .email(abstractUser.getEmail())
                                        .build()
                        )
                        .roles(Collections.singletonList(roleService.findByName(Role.Category.ROLE_STANDARD.name())))
                        .password(passwordEncoder.encode(abstractUser.getEmail()))
                        .type(User.Type.STANDARD)
                        .provider(request.getClientRegistration().getRegistrationId())
                        .build()
        );

        var account = Account.builder()
                .user(user)
                .active(true)
                .emailVerified(true)
                .locked(false)
                .picture(abstractUser.getProfile())
                .build();

        accountService.save(account);

        user.setAccount(account);

        return user;
    }
}
