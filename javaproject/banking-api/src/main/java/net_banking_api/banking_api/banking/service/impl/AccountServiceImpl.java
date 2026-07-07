package net_banking_api.banking_api.banking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net_banking_api.banking_api.banking.dto.AccountDto;
import net_banking_api.banking_api.banking.entity.Account;
import net_banking_api.banking_api.banking.mapper.AccountMapper;
import net_banking_api.banking_api.banking.repository.AccountRepository;
import net_banking_api.banking_api.banking.service.AccountService;

@Service

public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto){
        // Convert DTO to entity
        Account account = AccountMapper.mapToAccount(accountDto);

        // Save entity and capture the saved instance
        Account savedAccount = accountRepository.save(account);

        //convert the entity back to DTO
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        
        Account account = accountRepository
                              .findById(id)
                              .orElseThrow(() -> new RuntimeException("Account does not exist") );
                return AccountMapper.mapToAccountDto(account);            
    }

    @Override
    public AccountDto deposit(Long id, Double amount) {
        Account account = accountRepository
                              .findById(id)
                              .orElseThrow(() -> new RuntimeException("Account does not exist") );
        Double total = account.getAccountBalance() + amount;                      
        account.setAccountBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }


     @Override
    public AccountDto withdraw(Long id, Double amount) {

        Account account = accountRepository
                            .findById(id)
                            .orElseThrow(() -> new RuntimeException("Account does not exist"));

        if(account.getAccountBalance() < amount){
            throw new RuntimeException("Insufficient balance");
        }

        Double total = account.getAccountBalance() - amount;
        account.setAccountBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }

     @Override
     public List<AccountDto> getAllAccounts() {
        List <Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
        .collect(Collectors.toList());
     }

     @Override
     public void deleteAccount(Long id) {
       Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
       accountRepository.delete(account);
     }
     



    
}
