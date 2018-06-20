package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountService() {

    }


    public void verifyAccountById(Long accountId){
        if(accountRepository.findById(accountId).orElse(null) == null)throw new ResourceNotFoundException();
    }

    public Account createAccountFromCustomerId(Account account, Long costumerId){
        return accountRepository.save(account);
    }
    public Account getAccountById(Long accountId){
        return accountRepository.findById(accountId).orElse(null);
    }

    public ArrayList<Account> getAllAccountsByCustomerId(Long customerId){
        ArrayList<Account> accounts = accountRepository.getAccountsByCustomerIds(customerId);
        return accounts;
    }

    public ArrayList<Account> getAllAccounts(){
        ArrayList<Account> accounts = accountRepository.getAllAccounts();
        return new ArrayList<>();
    }

    public Account updateAccount(Account accountId){
        return accountRepository.save(accountId);
    }

    public void deleteAccountById(Long accountId){
        accountRepository.deleteAccountById(accountId);
    }

}
