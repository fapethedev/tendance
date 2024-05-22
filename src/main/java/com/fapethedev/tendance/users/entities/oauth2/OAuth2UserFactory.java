package com.fapethedev.tendance.users.entities.oauth2;

import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;

import java.util.Map;

/**
 * <p>Factory class for creating {@code OAuth2AbstractUser}.</p>
 *
 * @author Fapethedev
 * @since 1.0
 */
public abstract class OAuth2UserFactory
{
    /**
     * <p>Obtain an {@code OAuth2AbstractUser} using the factory method pattern
     * with OAuth2 provider id and map of attributes from his json response.</p>
     *
     * @param registrationId the OAuth2 provider identifier
     * @param attributes the map of attributes following the provider registration id
     *
     * @return {@code OAuth2AbstractUser} the OAuth2 corresponding to the registration
     * identifier with the right attributes
     *
     * @throws IllegalArgumentException if the registration id don't match any supported provider
     */
    public static OAuth2AbstractUser getOAuth2User(String registrationId, Map<String, Object> attributes)
    {
        if (registrationId.equalsIgnoreCase(CommonOAuth2Provider.GOOGLE.name()))
        {
            return new OAuth2GoogleUser(attributes);
        }
        else if (registrationId.equalsIgnoreCase(CommonOAuth2Provider.GITHUB.name()))
        {
            return new OAuth2GithubUser(attributes);
        }
        else
        {
            throw new IllegalArgumentException("Invalid registrationId only GITHUB and GOOGLE are available");
        }
    }
}
