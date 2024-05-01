package com.fapethedev.tendance.events.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

/**
 * {@code PlaceForm} is the form class for {@link com.fapethedev.tendance.events.entities.Place}
 * it's also use in {@link EventForm} as the place of the {@code Event}
 * @author Fapethedev
 * @since 1.0
 */
@Data @Builder
public class PlaceForm
{
    /**
     * The name of the place. In most cases, the common name will be used.
     * It's the only mandatory field in the {@code PlaceForm}.
     * <br/>
     * The value of the field name cannot be null or an empty string
     */
    @NotNull
    @NotBlank
    private String name;

    /**
     * The place geographic latitude coordinates
     * <br/>
     * This field can be unspecified or null.
     */
    private String latitude;

    /**
     * The place geographic longitude coordinates.
     * <br/>
     * This field can be unspecified or null.
     */
    private String longitude;

    /**
     * The country which the place is located.
     * <br/>
     * This field can be unspecified or null.
     */
    private String country;

    /**
     * The city which the place is located.
     * <br/>
     * This field can be unspecified or null.
     */
    private String city;

    /**
     * The town which the place is located
     * <br/>
     * This field can be unspecified or null.
     */
    private String town;

    /**
     * The scope of the place.
     * A private place will just see his name shared with other users.
     * <br/>
     * This field can be unspecified or null.
     */
    private String scope;
}
