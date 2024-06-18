package com.fapethedev.tendance.users.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * <p>Application user entity. This is the central entity in the app
 * as every action is doing by an user. User is used to authenticated with
 * username and password so it's implements UserDetails.</p>
 *
 * @see org.springframework.security.core.userdetails.UserDetails
 * @see com.fapethedev.tendance.main.entities.BaseEntity
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 2.0
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor @Builder
public class User extends BaseEntity<UUID> implements UserDetails
{
    public User() {
        this.createdAt = LocalDateTime.now();
    }

    @Embedded
    private UserIdentity identity;

    @Embedded
    private UserAddress address;

    @Column(nullable = false)
    private String password;

    @Column
    private String nomOrganisation;

    @Column
    private String emailOrganisation;

    @Column
    private String siege;

    @Column
    private String description;

    @Column
    private String siteWeb;

    @Column
    private String provider;

    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Account account;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return this.identity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !account.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return account.isActive();
    }

    /**
     * <p>{@code Type} is the type of user.</p>
     * <p>It's start with ADMIN which is the highest type and finish with STANDARD the lowest type</p>
     *
     * @author <a href="https://github.com/fapethedev">Fapethedev</a>
     * @version 1.0
     */
    public enum Type
    {
        ADMIN,
        STANDARD,
        ORGANIZER,
        SERVICES_PROVIDER,
        SPONSOR
    }
}
