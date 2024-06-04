package com.fapethedev.tendance.users.services;

import com.fapethedev.tendance.main.services.IService;
import com.fapethedev.tendance.users.entities.Account;
import com.fapethedev.tendance.users.form.AccountForm;
import com.fapethedev.tendance.users.repositories.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>A service layer class for doing crud operations
 * on Account entity by using AccountForm.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService implements IService<Account, UUID, AccountForm>
{
    private final AccountRepository accountRepository;

    @Override
    public Account save(Account account)
    {
        log.info("Saving account");

        return accountRepository.save(account);
    }

    @Override
    public Account save(AccountForm accountForm)
    {
        log.info("Saving account");

        var account = Account.builder()
                .picture(accountForm.getPicture())
                .idProof(accountForm.getIdProof())
                .bio(accountForm.getBio())
                .user(accountForm.getUser())
                .active(accountForm.isActive())
                .build();

        if (accountForm.getId() != null)
            account.setId(accountForm.getId());

        return accountRepository.save(account);
    }

    @Override
    public Account delete(Account account)
    {
        log.info("Deleting account");

        accountRepository.delete(account);

        return account;
    }

    @Override
    public Account deleteById(UUID uuid)
    {
        log.info("Deleting account");

        return delete(findById(uuid));
    }

    @Override
    public Account findById(UUID uuid)
    {
        log.info("Finding account with id : " + uuid);

        return accountRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id : " + uuid));
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
