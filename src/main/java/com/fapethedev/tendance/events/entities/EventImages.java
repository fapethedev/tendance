package com.fapethedev.tendance.events.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Event image url object
 * @author fapethedev
 * @since 1.0
 */
@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "main",
                column = @Column(
                        name = "main_img", nullable = true
                )
        ),
        @AttributeOverride(
                name = "second",
                column = @Column(
                        name = "secondary_img", nullable = true
                )
        ),
        @AttributeOverride(
                name = "third",
                column = @Column(
                        name = "third_img", nullable = true
                )
        ),
})
public class EventImages
{
    /**
     * The principal event's promotion image. It's optional
     */
    @Column
    private String main;

    /**
     * The secondary event's promotion image. It's optional
     */
    @Column
    private String second;

    /**
     * The third event's image. It's optional
     */
    @Column
    private String third;
}
