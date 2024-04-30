package com.fapethedev.tendance.users.services.impl;

import com.fapethedev.tendance.users.entities.Account;
import com.fapethedev.tendance.users.form.AccountForm;
import com.fapethedev.tendance.users.repositories.AccountRepository;
import com.fapethedev.tendance.users.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Fapethedev
 * @version 1.0
 *
 * A service layer class for doing crud operations
 * on Account entity by using AccountForm
 */
@Service
public class AccountService implements CrudService<Account, AccountForm>
{
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(AccountForm accountForm)
    {
        Account account = Account.builder()
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
    public Account delete(AccountForm accountForm)
    {
        Account account = Account.builder()
                .picture(accountForm.getPicture())
                .idProof(accountForm.getIdProof())
                .bio(accountForm.getBio())
                .user(accountForm.getUser())
                .active(accountForm.isActive())
                .build();

        account.setId(accountForm.getId());

        accountRepository.delete(account);

        return account;
    }

    @Override
    public Account findById(AccountForm accountForm)
    {
        Optional<Account> optionalAccount = accountRepository.findById(accountForm.getId());

        return null;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
