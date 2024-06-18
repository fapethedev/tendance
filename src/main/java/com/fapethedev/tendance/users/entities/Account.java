package com.fapethedev.tendance.users.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * <p>Every user in the app has an account.User details account relative method
 * use account attributes on user entity to returned the result.</p>
 *
 * @see com.fapethedev.tendance.main.entities.BaseEntity
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Entity 
@Builder
@Getter @Setter 
@AllArgsConstructor
@Table(name = "accounts")
public class Account extends BaseEntity<UUID>
{
    public Account() {
        active = false;
        locked = false;
        emailVerified = false;
    }

    @Column(name = "profile_pic", nullable = true)
    private String picture;

    @Column(name = "id_proof", nullable = true)
    private String idProof;

    @Column(name = "bio", nullable = true)
    private String bio;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "isActive", nullable = false)
    private boolean active;

    @Column(name = "isLocked", nullable = false)
    private boolean locked;

    @Column(name = "isEmail_Verified", nullable = false)
    private boolean emailVerified;
}
