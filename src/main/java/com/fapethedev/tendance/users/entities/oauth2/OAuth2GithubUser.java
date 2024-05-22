package com.fapethedev.tendance.users.entities.oauth2;

import java.util.Map;

/**
 * <p>{@code OAuth2GithubUser} is a realization of {@code OAuth2AbstractUser}
 * with GitHub as OAuth2 provider.</p>
 *
 * <p>{@code OAuth2GithubUser} is use when a user is login or register with
 * GitHub.</p>
 *
 * @see com.fapethedev.tendance.users.entities.oauth2.OAuth2AbstractUser
 *
 * @author Fapethedev
 * @version 1.0
 */
public class OAuth2GithubUser extends OAuth2AbstractUser
{
    /**
     * <p>Creates a new {@code OAuth2GithubUser} with the specified
     * constructor parameters.</p>
     *
     * @param attributes the map of attributes from GitHub
     */
    public OAuth2GithubUser(Map<String, Object> attributes) {
        super(attributes);
    }

    /**
     * <p>Gets the email address of the user with the key 'email'
     * according to GitHub json response.</p>
     *
     * @return the email of the user with GitHub
     */
    @Override
    public String getEmail()
    {
        return (String) attributes.get("email");
    }

    /**
     * <p>Gets the name of the user with the key 'avatar_url'
     * according to GitHub json response.</p>
     *
     * @return the profile of the user knows as avatar image with GitHub
     */
    @Override
    public String getProfile()
    {
        return (String) attributes.get("avatar_url");
    }

    /**
     * <p>Gets the name of the user with the key 'name' according
     * to GitHub json response.</p>
     *
     * @return the name or fullname of the user
     */
    @Override
    public String getName()
    {
        return (String) attributes.get("name");
    }
}
