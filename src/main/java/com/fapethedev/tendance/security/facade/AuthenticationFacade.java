package com.fapethedev.tendance.security.facade;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface AuthenticationFacade
{
    Authentication getAuthentication();

    void setAuthentication(String username, String password, Collection<? extends GrantedAuthority> authorities);
}
