package com.fapethedev.tendance.security.facade;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
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

    @Override
    public void authWithUsernamePassword(UserDetails user, HttpServletRequest request)
    {
        var strategy = SecurityContextHolder.getContextHolderStrategy();

        var context = strategy.getDeferredContext().get();

        var authentication = new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities());

        context.setAuthentication(authentication);

        strategy.setDeferredContext(() -> context);

        var session = request.getSession(true);

        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);

    }
}