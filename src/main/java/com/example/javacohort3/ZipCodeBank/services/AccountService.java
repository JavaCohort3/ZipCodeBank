package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Customer;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.CustomerRepository;
import com.example.javacohort3.ZipCodeBank.util.Burn;
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
        verifyCustomerById(customerId);
        return customerRepository.findCustomerById(customerId);
    }

    public List<Account> getAllAccounts() {
        List<Account> accounts = (List<Account>) accountRepository.findAll();
        verifyAccountById((long) accounts.size());
        return accounts;
    }

    public List<Account> getAccountsByCustomerId(Long customerId){
        verifyCustomerById(customerId);
        ArrayList<Account> accounts = (ArrayList<Account>) accountRepository.findAll();
        verifyAccountById((long) accounts.size());
        accounts.removeIf(a -> !a.getCustomer().getId().equals(customerId));

        return accounts;
    }

    public Account getAccountById (Long id){
        return accountRepository.findAccountById(id);
    }

    public Account updateAccount(Account account){
        // verifies account before proceeding
        verifyAccountById(account.getId());

        // sets old account to variable
        Account oldAccount = getAccountById(account.getId());

        // casts Burn.updateObjectFields return value to Account
        account = (Account) Burn.updateObjectFields(account, oldAccount);

        // saves and returns customer
        return accountRepository.save(account);
    }

    public void deleteAccountById(Long id){
        verifyAccountById(id);
        accountRepository.deleteById(id);
    }
}