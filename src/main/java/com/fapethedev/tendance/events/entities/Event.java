package com.fapethedev.tendance.events.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import com.fapethedev.tendance.users.entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Event entity class
 */
@Entity
@Table(name = "events")
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Event extends BaseEntity<UUID>
{
    /**
     * The name of the event
     */
    @Column(nullable = false)
    private String name;

    /**
     * The description of the event
     */
    @Column(nullable = false)
    private String description;

    /**
     * The list of all three event covers
     */
    @Embedded
    private EventImages images;

    /**
     * The list of all three event promotional videos
     */
    @Embedded
    private EventVideos videos;

    /**
     * The date and time which the event will start
     */
    @Column
    private LocalDateTime startDateTime;

    /**
     * The date and time which the event will end
     */
    @Column
    private LocalDateTime endDateTime;

    /**
     * The status of the event
     */
    @Column
    @Enumerated(EnumType.STRING)
    private EventState state;

    /**
     * <p>The scope of the event as it can be public or private.</p>
     */
    @NotNull
    @NotBlank
    private String scope;

    /**
     * The user who creates the event <br/>
     * He should be of type of Organizer
     */
    @JoinColumn
    @ManyToOne
    private User user;

    /**
     * The place of the event
     */
    @JoinColumn
    @ManyToOne
    private Place place;

    @JoinColumn
    @OneToMany
    private List<Prestation> prestations;
}
