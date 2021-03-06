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
public class CustomerService {
    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    // Verify
    public void verifyCustomer(Long id) {
        if (customerRepository.findCustomerById(id) == null) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "error fetching customer");
        }
    }

    public void verifyAccount(Long id) {
        if (accountRepository.findAccountById(id) == null) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "error fetching account");
        }
    }

    // Create
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get
    public Customer getCustomerById(Long id) {
        verifyCustomer(id);
        return customerRepository.findCustomerById(id);
    }

    // Get By Account ID
    public Customer getCustomerByAccountId(Long accountId) {
        verifyAccount(accountId);
        ArrayList<Account> accounts = (ArrayList<Account>) accountRepository.findAll();
        for (Account account : accounts) {
            if (account.getId().equals(accountId)) {
                // verifyCustomer(account.getCustomer().getId());
                return account.getCustomer();
            }
        }

        throw new ResourceNotFoundException();
    }

    // Get All
    public List<Customer> getAllCustomers() {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        verifyCustomer((long) customers.size());
        return customers;
    }

    // Update
    public Customer updateCustomer(Customer customer) {
        // verifies customer before proceeding
        verifyCustomer(customer.getId());

        // sets old customer to variable
        Customer oldCustomer = getCustomerById(customer.getId());

        // casts Burn.updateObjectFields return value to Customer
        customer = (Customer) Burn.updateObjectFields(customer, oldCustomer);

        // saves and returns customer
        return customerRepository.save(customer);
    }

    // Delete
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
