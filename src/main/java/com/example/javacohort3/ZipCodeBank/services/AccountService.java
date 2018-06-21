package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountService() {

    }


    public void verifyAccountById(Long accountId){
        if(accountRepository.existsByAccountId(accountId)){
            getAccountById(accountId);
        }
        else {
            throw new ResourceNotFoundException();
        }
    }


    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public Account getAccountByCustomerId (Long customerId){
        return accountRepository.findAccountByCustomerId(customerId);
    }

    public List<Account> getAllAccountsByCustomerFirst_Name(String customerFirst_Name){
        List<Account> accountsList = new ArrayList<>();
        accountRepository.findByCustomerFirstName(customerFirst_Name).forEach(accountsList::add);

        return accountsList;
    }

    public Account getAccountById (Long id){
        return accountRepository.findById(id).orElse(null);

    }

    public Account updateAccount(Account account){
        return accountRepository.save(account);
    }


    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }

}
