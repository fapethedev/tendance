package com.fapethedev.tendance.users.entities.oauth2;

import java.util.Map;

/**
 * <p>{@code OAuth2GoogleUser} is a realization of {@code OAuth2AbstractUser}
 * with Google as OAuth2 provider.</p>
 *
 * <p>{@code OAuth2GoogleUser} is use when a user is login or register with
 * Google.</p>
 *
 * @see com.fapethedev.tendance.users.entities.oauth2.OAuth2AbstractUser
 * @see com.fapethedev.tendance.users.entities.oauth2.OAuth2GithubUser
 *
 * @author Fapethedev
 * @version 1.0
 */
public class OAuth2GoogleUser extends OAuth2AbstractUser
{
    /**
     * <p>Creates a new {@code OAuth2GoogleUser} with the specified
     * constructor parameters.</p>
     *
     * @param attributes the map of attributes from Google
     */
    public OAuth2GoogleUser (Map<String, Object> attributes) {
        super(attributes);
    }

    /**
     * <p>Gets the email address of the user with the key 'email'
     * according to Google json response.</p>
     *
     * @return the email of the user with Google
     */
    @Override
    public String getEmail()
    {
        return (String) attributes.get("email");
    }

    /**
     * <p>Gets the profile of the user with the key 'picture'
     * according to Google json response.</p>
     *
     * @return the profile of the user knows as picture image with Google
     */
    @Override
    public String getProfile()
    {
        return (String) attributes.get("picture");
    }

    /**
     * <p>Gets the name of the user with the key 'name' according
     * to Google json response.</p>
     *
     * @return the name or fullname of the user with Google
     */
    @Override
    public String getName()
    {
        return (String) attributes.get("name");
    }
}
