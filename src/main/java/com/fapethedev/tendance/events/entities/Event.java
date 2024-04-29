package com.fapethedev.tendance.events.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import com.fapethedev.tendance.users.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Event entity class
 */
@Entity
@Table(name = "events")
@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
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
}
