package com.fapethedev.tendance.events.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * The place of the event
 * @author Fapethedev
 * @since 1.0
 */
@Entity
@Table(name = "places")
@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class Place extends BaseEntity<UUID>
{
    /**
     * The name of the place
     */
    @Column(nullable = false)
    private String name;

    /**
     * The latitude of the place
     */
    @Column
    private String latitude;

    /**
     * The longitude of the place
     */
    @Column
    private String longitude;

    /**
     * The country where the place is located
     */
    @Column
    private String country;

    /**
     * The city where the place is located
     */
    @Column
    private String city;

    /**
     * The town where the place is located
     */
    @Column
    private String town;

    /**
     * The scope of the place <br>
     * A place con be private or public.
     */
    @Column
    private String scope;

    /**
     * The list of all events which use this place
     */
    @JoinColumn
    @OneToMany
    private List<Event> events;
}
