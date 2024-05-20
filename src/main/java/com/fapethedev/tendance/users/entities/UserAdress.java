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
public class UserAdress
{
    private String phone;

    private String city;

    private String country;
}
