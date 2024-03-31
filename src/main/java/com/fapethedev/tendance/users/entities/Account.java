package com.fapethedev.tendance.users.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity @Builder
@Getter @Setter @AllArgsConstructor
@Table(name = "accounts")
public class Account extends BaseEntity<UUID>
{
    public Account() {
        active = false;
        locked = false;
    }

    @Column(name = "profile_pic", nullable = true)
    private String picture;

    @Column(name = "id_proof", nullable = true)
    private String idProof;

    @Column(name = "bio", nullable = true)
    private String bio;

    @OneToOne
    private User user;

    @Column(name = "isActive", nullable = false)
    private boolean active;

    @Column(name = "isLocked", nullable = false)
    private boolean locked;
}
