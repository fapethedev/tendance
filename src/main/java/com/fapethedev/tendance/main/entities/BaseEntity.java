package com.fapethedev.tendance.main.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode(of = "id")
@MappedSuperclass
@Getter @Setter
public class BaseEntity<T extends Serializable> implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected T id;

    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @Column(nullable = false, updatable = true)
    protected LocalDateTime updatedAt;

    @Column(nullable = false, updatable = true)
    protected Boolean deleted;

    @Version
    private Long version;

    @PreUpdate
    public void onUpdate()
    {
        this.updatedAt = LocalDateTime.now();
    }

    @PrePersist
    public void onCreate()
    {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
        this.deleted = false;
    }
}
