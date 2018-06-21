package io.elitejava3.BankAPI.services;

import io.elitejava3.BankAPI.domains.Account;
import io.elitejava3.BankAPI.domains.Customer;
import io.elitejava3.BankAPI.exceptions.ResourceNotFoundException;
import io.elitejava3.BankAPI.repositories.AccountRepository;
import io.elitejava3.BankAPI.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        if (accountRepository.findAccountById(id) == null) throw new ResourceNotFoundException();
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