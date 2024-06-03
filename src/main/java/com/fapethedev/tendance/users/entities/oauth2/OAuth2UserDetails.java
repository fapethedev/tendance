package com.fapethedev.tendance.users.entities.oauth2;

import com.fapethedev.tendance.users.entities.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * <p>This class will serve for Spring Security authentication
 * by implementing {@code UserDetails} spring security will use
 * the given username, password, the granted authorities and more.</p>
 *
 * <p>The {@code OAuth2UserDetails} will be return as {@code OAuth2User}
 * when the OAuth2UserService loadUser method with OAuth2UserRequest in paremeter
 * will be call.</p>
 *
 * @see org.springframework.security.oauth2.core.user.OAuth2User
 * @see org.springframework.security.core.userdetails.UserDetails
 *
 * @author Fapethedv
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class OAuth2UserDetails implements OAuth2User, UserDetails
{
    private UUID id;

    private String username;

    private String password;

    private Account account;

    private Collection<? extends GrantedAuthority> authorities;

    private Map<String, Object> attributes;

    public OAuth2UserDetails(UUID id, String username, String password, Account account, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.account = account;
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !account.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return account.isActive();
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes ;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return String.valueOf(id);
    }

    @Override
    public <A> A getAttribute(String name) {
        return OAuth2User.super.getAttribute(name);
    }
}
