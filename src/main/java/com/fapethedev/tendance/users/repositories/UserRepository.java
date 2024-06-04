package com.fapethedev.tendance.users.repositories;

import com.fapethedev.tendance.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * <p>The database layer interface class for crud operations
 * on {@code User} entity.</p>
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID>
{
    /**
     * <p>Find a user with his email as emails
     * are uniques for user.</p>
     *
     * @param email the user email as username
     *
     * @return optional of user
     */
    @Query("SELECT u FROM User u WHERE u.identity.email =:email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.identity.email =:email AND u.provider =:provider")
    Optional<User> findByEmailAndProvider(@Param("email") String email, @Param("provider") String provider);

    /**
     * <p>Get the number of user with a specific email.
     * Email is unique for a user so if a user has this
     * email 1 should be returned otherwise .</p>
     *
     * @param email the user email as username
     *
     * @return the number of user with the email, expect 1
     * if the user exist and zero if not
     */
    @Query("SELECT COUNT(1) FROM User U WHERE U.identity.email =:email")
    Long countByEmail(@Param("email") String email);

    /**
     * <p>Performing a soft delete on user by deactivate his account.</p>
     *
     * @param username the user email as username
     */
    @Modifying
    @Query("UPDATE User U SET U.account.active=false WHERE U.identity.email =:email")
    void deleteByUsername(@Param("email") String username);
}
