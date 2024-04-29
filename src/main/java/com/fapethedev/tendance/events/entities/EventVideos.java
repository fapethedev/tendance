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
 * Event video url object
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
                name = "primary",
                column = @Column(
                        name = "primary_vid", nullable = true
                )
        ),
        @AttributeOverride(
                name = "secondary",
                column = @Column(
                        name = "secondary_vid", nullable = true
                )
        ),
        @AttributeOverride(
                name = "third",
                column = @Column(
                        name = "third_vid", nullable = true
                )
        ),
})
public class EventVideos
{
    /**
     * The primary event's promotion video. It's optional
     */
    @Column
    private String primary;

    /**
     * The secondary event's promotion video. It's optional
     */
    @Column
    private String secondary;

    /**
     * The third event's promotion video. It's optional
     */
    @Column
    private String third;
}
