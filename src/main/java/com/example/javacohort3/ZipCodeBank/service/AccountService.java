package com.example.javacohort3.ZipCodeBank.service;

import com.example.javacohort3.ZipCodeBank.Account;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
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
