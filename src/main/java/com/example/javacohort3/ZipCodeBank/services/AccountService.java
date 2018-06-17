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

    public void verifyAccountById(Long accountId){
        if(accountRepository.findById(accountId).orElse(null) == null)throw new ResourceNotFoundException();
    }

    public Account createAccountFromCustomerId(Account account, Long costumerId){
        Account account1 = accountRepository.findById(costumerId).orElse(null);
        account.setCustomer(account.getCustomer());
       //binds customerId to account
        account.setId(costumerId);
        return accountRepository.save(account);
    }
    public ArrayList<Account> getAllAccountsByCustomerId(Long customerId){
        ArrayList<Account> accounts = accountRepository.getAccountsByCustomerIds(customerId);
        return accounts;
    }

    public ArrayList<Account> getAllAccounts(){
        ArrayList<Account> accounts = accountRepository.getAllAccounts();
        return new ArrayList<>();
    }


    public Account updateAccount(Account account, Long accountId){
        return accountRepository.save(account);
    }

    public void deleteAccount(Long accountId){
        accountRepository.deleteAccountById(accountId);
    }

}
