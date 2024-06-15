package com.fapethedev.tendance.users.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>Embedded object that's represent the identity of a user which is defined by
 * the user lastname, firstname and his email.Since user can register with OAuth2 protocol
 * the lastname and firstname become nullable field because some provider don't give these
 * informations.</p>
 *
 * @see User
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "lastname",
                column = @Column(
                        name = "lastname", nullable = true
                )
        ),
        @AttributeOverride(
                name = "firstname",
                column = @Column(
                        name = "firstname", nullable = true
                )
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(
                        name = "email", nullable = false, unique = true
                )
        ),
})
public class UserIdentity implements Serializable
{
    /**
     * <p>The lastname of the user.Can be null.</p>
     */
    private String lastname;

    /**
     * <p>The firstname of the user. Can be null.</p>
     */
    private String firstname;

    /**
     * <p>The user email address which is the only required
     * field here and are unique for every user.</p>
     */
    private String email;
}