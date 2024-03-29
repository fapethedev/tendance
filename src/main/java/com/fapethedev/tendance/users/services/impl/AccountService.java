package com.fapethedev.tendance.users.services.impl;

import com.fapethedev.tendance.users.dto.AccountDto;
import com.fapethedev.tendance.users.entities.Account;
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
 * on Account entity by using AccountDto
 */
@Service
public class AccountService implements CrudService<Account, AccountDto>
{
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(AccountDto accountDto)
    {
        Account account = Account.builder()
                .picture(accountDto.getPicture())
                .idProof(accountDto.getIdProof())
                .bio(accountDto.getBio())
                .user(accountDto.getUser())
                .active(accountDto.isActive())
                .build();

        if (accountDto.getId() != null)
            account.setId(accountDto.getId());

        return accountRepository.save(account);
    }

    @Override
    public Account delete(AccountDto accountDto)
    {
        Account account = Account.builder()
                .picture(accountDto.getPicture())
                .idProof(accountDto.getIdProof())
                .bio(accountDto.getBio())
                .user(accountDto.getUser())
                .active(accountDto.isActive())
                .build();

        account.setId(accountDto.getId());

        accountRepository.delete(account);

        return account;
    }

    @Override
    public Account findById(AccountDto accountDto)
    {
        Optional<Account> optionalAccount = accountRepository.findById(accountDto.getId());

        return null;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
