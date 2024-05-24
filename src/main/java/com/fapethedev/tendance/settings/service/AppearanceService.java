package com.fapethedev.tendance.settings.service;

import com.fapethedev.tendance.settings.entities.Appearance;
import com.fapethedev.tendance.settings.form.AppearanceForm;
import com.fapethedev.tendance.settings.repositories.AppearanceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>{@code AppearanceService} is the concrete {@code IAppearanceService}
 * implementations.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 * @see com.fapethedev.tendance.settings.service.IAppearanceService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AppearanceService implements IAppearanceService<UUID>
{
    private final AppearanceRepository<UUID> appearanceRepository;

    @Override
    public Appearance save(Appearance appearance)
    {
        log.info("Saving or update appearance");

        return appearanceRepository.save(appearance);
    }

    @Override
    public Appearance save(AppearanceForm appearanceForm)
    {
        log.info("Saving appearance");

        return Appearance.builder()
                .theme(appearanceForm.getTheme())
                .border(appearanceForm.getBorder())
                .card(appearanceForm.getCard())
                .layout(appearanceForm.getLayout())
                .color(appearanceForm.getColor())
                .sizing(appearanceForm.getSizing())
                .direction(appearanceForm.getDirection())
                .user(appearanceForm.getUser())
                .build();
    }

    @Override
    public Appearance delete(Appearance appearance)
    {
        log.info("Deleting Appearance " + appearance.getId());

        return appearance;
    }

    @Override
    public Appearance deleteById(UUID uuid)
    {
        log.info("Deleting Appearance " + uuid);

        return delete(findById(uuid));
    }

    @Override
    public Appearance findById(UUID uuid)
    {
        log.info("Finding Appearance " + uuid);

        return appearanceRepository.findById(uuid)
                .orElseThrow(() -> new  EntityNotFoundException("Could not find Appearance " + uuid));
    }

    @Override
    public List<Appearance> findAll()
    {
        return appearanceRepository.findAll(Sort.by("user_id"));
    }

    @Override
    public Appearance findAppearanceByUserId(UUID userId)
    {
        log.info("Finding appearance by user id " + userId);

        return appearanceRepository.findAppearanceByUserId(userId)
                .orElseThrow();
    }
}
