package com.fapethedev.tendance.users.entities.oauth2;

import java.util.Map;

/**
 * <p>{@code OAuth2AbstractUser} is the abstract class that defines all the properties
 * and common methods that an user that try to login with OAuth2 protocol should have.
 * If the user email address is already in the database meaning he has an account
 * otherwise an account will be create for him with this email as username.
 * <br/>
 * It's important to notice that if an user didn't have an account yet, a realization
 * of {@code OAuth2AbstractUser} will be use according the OAuth2 provider for retrieving
 * common properties value from the attributes map with the corresponding key like
 * the email, the name or fullname from some provider and the profile picture.</p>
 *
 * <p>Second notice is there is only one {@code User} entity and the {@code OAuth2AbstractUser}
 * is a placeholder class for creating {@code User} entity with only the email serving
 * as username, the name or fullname and the profile following the usage of OAuth2
 * to register his account.So there is no password taken from the OAuth2 provider in other
 * way a secure random password is generate and sent to the user email address.</p>
 *
 * @author Fapethedev
 * @version 1.0
 */
public abstract class OAuth2AbstractUser
{
    /**
     * <p>The list of user attributes given by the OAuth2 provider.
     * All attributes are in json format and mapped into a map of
     * {@code String} as key and {@code Object} as value.</p>
     */
    protected Map<String, Object> attributes;

    /**
     * <p>OAuth2Users constructor method with the provider json response as parameter.</p>
     * @param attributes the map of json attributes
     */
    public OAuth2AbstractUser(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    /**
     * <p>Retrieving the email address with the corresponding key in the map of attributes.</p>
     *
     * @return the email address given his key value in the map of attributes
     */
    public abstract String getEmail();

    /**
     * <p>Gets the user profile by the corresponding key in the map of attributes.</p>
     *
     * @return the profile of user value following the given key in the map of attributes
     */
    public abstract String getProfile();

    /**
     * <p>Gets the user name or full name by the corresponding key in the map of attributes.</p>
     *
     * @return the name of user value following the given key in the map of attributes
     */
    public abstract String getName();
}
