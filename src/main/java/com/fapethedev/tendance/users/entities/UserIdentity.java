package com.fapethedev.tendance.users.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder @NoArgsConstructor @AllArgsConstructor
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
public class UserIdentity
{
    private String lastname;

    private String firstname;

    private String email;
}