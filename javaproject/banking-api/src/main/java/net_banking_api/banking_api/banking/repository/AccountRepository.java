package net_banking_api.banking_api.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net_banking_api.banking_api.banking.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
