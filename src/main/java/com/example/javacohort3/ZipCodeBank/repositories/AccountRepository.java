package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account createAccountFromCustomerId(Account account, Long customerId);
    ArrayList<Account> getAccountsByCustomerIds(Long customerId);
    ArrayList<Account> getAllAccounts();
    Account getAccountById(Long accountId);
    Account updateAccount(Account account);
    void deleteAccountById(Long accountId);
}
