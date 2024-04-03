package com.fapethedev.tendance.users.repositories;

import com.fapethedev.tendance.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>
{
    @Query("select u from User u where u.identity.email =:email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("SELECT COUNT(1) FROM User U WHERE U.identity.email =:email")
    Long countByEmail(@Param("email") String email);

    @Modifying
    @Query("UPDATE User U SET U.account.active=false WHERE U.identity.email =:email")
    void deleteByUsername(@Param("email") String username);
}
