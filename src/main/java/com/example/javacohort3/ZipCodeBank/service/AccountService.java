package com.example.javacohort3.ZipCodeBank.service;


import com.example.javacohort3.ZipCodeBank.Account;

import com.example.javacohort3.ZipCodeBank.Customer;

import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Account createAccount(Account account){
        return account;
    }
}
    public Customer getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
}

