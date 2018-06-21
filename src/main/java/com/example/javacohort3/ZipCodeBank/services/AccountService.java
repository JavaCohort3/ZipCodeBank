package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Account;

import com.example.javacohort3.ZipCodeBank.domains.Customer;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private CustomerService customerService;

    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    public void verifyAccountById(Long id){
        if (accountRepository.findAccountById(id) == null) throw new io.elitejava3.BankAPI.exceptions.ResourceNotFoundException();
    }

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public Account getAccountsByCustomerId(Long customerId){
        customerService.verifyCustomer(customerId);
        Customer c = customerRepository.findCustomerById(customerId);
        ArrayList<Account> accounts = (ArrayList<Account>) accountRepository.findAll();
        return accounts.stream().filter(x -> x.getCustomer().getId().equals(customerId)).findFirst().get();
    }

    public Account getAccountById (Long id){
        return accountRepository.findAccountById(id);
    }

    public Account updateAccount(Account account){
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id){
        accountRepository.deleteAccountById(id);
    }
}