package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Customer;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public void verifyCustomerById(Long id) {
        if (customerRepository.findCustomerById(id) == null) throw new ResourceNotFoundException(HttpStatus.NOT_FOUND,"\'error fetching account\'");
    }

    public void verifyAccountById(Long id){
        if (accountRepository.findAccountById(id) == null) throw new ResourceNotFoundException(HttpStatus.NOT_FOUND,"\'error fetching account\'");
    }

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findCustomerById(customerId);
    }

    public List<Account> getAllAccounts() {
        return (ArrayList<Account>) accountRepository.findAll();
    }

    public List<Account> getAccountsByCustomerId(Long customerId){
        ArrayList<Account> accounts = (ArrayList<Account>) accountRepository.findAll();
        accounts.removeIf(a -> !a.getCustomer().getId().equals(customerId));

        return accounts;
    }

    public Account getAccountById (Long id){
        return accountRepository.findAccountById(id);
    }

    public Account updateAccount(Account account){
        return accountRepository.save(account);
    }

    public void deleteAccountById(Long id){
        accountRepository.deleteById(id);
    }
}