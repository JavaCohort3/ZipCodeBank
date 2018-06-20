package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface AccountRepository extends CrudRepository<Account, Long> {
//    Account createAccountFromCustomerId(Account account, Long customerId);
    ArrayList<Account> findAllAccountsByCustomerId(Long customerId);
//    ArrayList<Account> findAllAccounts();
//    Account findAccountById(Long accountId);
//    Account updateAccount(Account account, Long accountId);
//    void deleteAccountById(Long accountId);
}
