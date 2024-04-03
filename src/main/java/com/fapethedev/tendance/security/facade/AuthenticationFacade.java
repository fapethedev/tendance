package com.fapethedev.tendance.security.facade;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade
{
    Authentication getAuthentication();
}
