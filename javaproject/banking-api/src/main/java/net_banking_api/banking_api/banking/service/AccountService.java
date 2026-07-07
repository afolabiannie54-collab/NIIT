package net_banking_api.banking_api.banking.service;

import java.util.List;

import net_banking_api.banking_api.banking.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto); // method to create a new account

    AccountDto getAccountById(Long id); //method to get account by id

    AccountDto deposit(Long id, Double amount); // method to deposit amount into account

    AccountDto withdraw(Long id, Double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);

    
}

