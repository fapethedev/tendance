package com.fapethedev.tendance.users.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class Role extends BaseEntity<UUID>
{
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy="roles")
    private List<User> users;

    public enum Category
    {
        ADMIN("admin"),
        STANDARD("standard"),
        ORGANIZATION("organization"),
        SERVICEPROVIDER("service_provider"),
        SPONSOR("sponsor");

        private String name;

        Category(String name)
        {
            this.name = name;
        }
    }
}
