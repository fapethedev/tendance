package com.fapethedev.tendance.settings.repositories;

import com.fapethedev.tendance.settings.entities.Appearance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * <p>Repository interface for jpa operation on {@code Appearance}
 * entities.</p>
 *
 * @param <T> the type of Appearance entity id
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Repository
public interface AppearanceRepository<T> extends JpaRepository<Appearance, UUID>
{
    /**
     * <p>Retrieving an Appearance with the id of the user that
     * user the appearance.</p>
     *
     * @param userId the id of the appearance user
     * @return Appearance wrapped in Optional
     */
    Optional<Appearance> findAppearanceByUserId(T userId);
}
