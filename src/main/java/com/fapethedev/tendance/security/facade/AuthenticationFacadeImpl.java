package com.fapethedev.tendance.security.facade;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * An implementation of {@link AuthenticationFacade}
 * to access authenticated user through security context holder
 *
 * @author Fapethedev
 * @version 1.0
 * @see com.fapethedev.tendance.security.facade.AuthenticationFacade
 */
@Component
public class AuthenticationFacadeImpl implements AuthenticationFacade
{
    /**
     * Get the authenticated user
     * @return the authenticated user
     */
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}