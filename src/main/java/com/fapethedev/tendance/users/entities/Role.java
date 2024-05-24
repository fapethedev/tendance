package com.fapethedev.tendance.users.entities;

import com.fapethedev.tendance.main.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * <p>Role entity in the application. Role serve to define users authorities.
 * Role value are fixe and are all declare in {@code Role.Category}.</p>
 *
 * <p>If the intention is to save or find role, the recommendation is to use the name
 * from {@code Role.Category.ROLE_XXX.name()}</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Entity
@Table(name = "roles")
@Getter @Setter
@NoArgsConstructor
public class Role extends BaseEntity<UUID>
{
    /**
     * The name of the role.
     */
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy="roles", fetch = FetchType.LAZY)
    private List<User> users;

    /**
     * <p>The constructor with the {@link  Role.Category}.</p>
     *
     * @param name the role category name
     */
    public Role(Category name) {
        this.name = name.name();
    }

    /**
     * <p>The categories of user's role.
     * They are used to find and save role too.</p>
     *
     * <p>Possible value are: <br/>
     * ROLE_ADMIN, <br/>
     * ROLE_STANDARD, <br/>
     * ROLE_ORGANIZATION, <br/>
     * ROLE_SERVICEPROVIDER, <br/>
     * ROLE_SPONSOR, <br/>
     * ROLE_VISITOR.<br/></p>
     */
    public enum Category
    {
        /**
         * <p>The administrator role also knows as the highest role a user can acquire,
         * giving him all the permissions and authorities in the application.</p>
         */
        ROLE_ADMIN("admin"),

        /**
         * <p>The standard role is the minimal a user who is registered and has
         * his account activated can possess. This role allow user to access his dashboard
         * and the cart.</p>
         */
        ROLE_STANDARD("standard"),

        /**
         * <p>The organization role is similar to the standard role but allow user
         * to create, manage and publish events entity in the application and a few
         * more like prestation request.</p>
         *
         * <p>A user with organization role can also communicate with other user exclude
         * standard's one and visitor.</p>
         */
        ROLE_ORGANIZATION("organization"),

        /**
         * <p>The service_provider role is similar to the standard role but allow user
         * to create, manage and publish delivery entity in the application and a few
         * more like prestation request and prestation.</p>
         *
         * <p>A user with organization role can also communicate with other user exclude
         * standard's one and visitor.</p>
         */
        ROLE_SERVICEPROVIDER("service_provider"),

        /**
         * <p>The sponsor role is intended to allow user to sponsoring events.
         * A user with sponsor role can also communicate with other user exclude
         * standard's one and visitor</p>
         */
        ROLE_SPONSOR("sponsor"),

        /**
         * <p>The visitor role is a particular role. This role has the mission to
         * serve as markup for a visitor on the application that doesn't have an
         * account but made a commentary.</p>
         *
         * <p>It's important to notice that he has an
         * account which is not active so he can't login with it. He need to register
         * with the form or oauth2</p>
         */
        ROLE_VISITOR("visitor");

        private String name;

        Category(String name)
        {
            this.name = name;
        }
    }
}
