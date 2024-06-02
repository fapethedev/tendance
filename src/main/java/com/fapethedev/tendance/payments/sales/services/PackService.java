package com.fapethedev.tendance.payments.sales.services;

import com.fapethedev.tendance.payments.sales.entities.PassPack;
import com.fapethedev.tendance.payments.sales.form.PackForm;
import com.fapethedev.tendance.payments.sales.repository.PackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>The service layer class for pack of ticket.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 * @see com.fapethedev.tendance.payments.sales.services.IPackService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PackService implements IPackService
{
    /**
     * <p>The ticket repository.</p>
     */
    private final PackRepository repository;

    @Override
    public PassPack save(PassPack pack)
    {
        log.info("Saving pack of ticket");

        return repository.save(pack);
    }

    @Override
    public PassPack save(PackForm form)
    {
        log.info("Saving pack of ticket with form");

        return repository.save(
                new PassPack(
                        form.getLogo(),
                        form.getPrice(),
                        form.getCurrency(),
                        form.getStock(),
                        form.getPassState(),
                        form.getPassType(),
                        form.getEvent(),
                        form.getPasses()
                )
        );
    }

    @Override
    public PassPack delete(PassPack pack)
    {
        log.info("Deleting pack");

        repository.delete(pack);

        return pack;
    }

    @Override
    public PassPack deleteById(UUID uuid)
    {
        log.info("Deleting pack with id: " + uuid);

        return delete(findById(uuid));
    }

    @Override
    public PassPack findById(UUID uuid)
    {
        log.info("Finding pack with id: " + uuid);

        return repository.findById(uuid).orElseThrow();
    }

    @Override
    public List<PassPack> findAll()
    {
        log.info("Finding all packs");

        return repository.findAll();
    }
}
