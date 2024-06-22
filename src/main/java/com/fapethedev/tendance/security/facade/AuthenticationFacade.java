package com.fapethedev.tendance.security.facade;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationFacade
{
    Authentication getAuthentication();

    void authWithUsernamePassword(UserDetails user, HttpServletRequest request);
}
