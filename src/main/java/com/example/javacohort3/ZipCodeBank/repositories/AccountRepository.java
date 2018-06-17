package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Account;

import java.util.ArrayList;

public interface AccountRepository {
    Account createAccountFromCustomerId(Account account, Long customerId);
    ArrayList<Account> getAccounsByCustomerId(Long customerId);
    ArrayList<Account> getAllAccounts();
    Account updateAccount(Account account);
    void deleteAccountById(Long accountId);

}
