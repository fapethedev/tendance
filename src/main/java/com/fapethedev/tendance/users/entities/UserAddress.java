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
 * <p>Embedded object that's represent the address of a user which is defined by
 * the user phone number, his resident country and city.Since the implementation of OAuth2 protocol
 * this is nullable entirely and only the phone number is asked when the login with the form is used.
 * </p>
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
                name = "phone",
                column = @Column(
                        name = "phone", nullable = true
                )
        ),
        @AttributeOverride(
                name = "city",
                column = @Column(
                        name = "city", nullable = true
                )
        ),
        @AttributeOverride(
                name = "country",
                column = @Column(
                        name = "country", nullable = true
                )
        ),
})
public class UserAddress implements Serializable
{
    /**
     * <p>The user phone number.</p>
     */
    private String phone;

    /**
     * <p>The user resident city.</p>
     */
    private String city;

    /**
     * <p>The user resident country.</p>
     */
    private String country;
}
