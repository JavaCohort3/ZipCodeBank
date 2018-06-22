package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Customer;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (customerRepository.findCustomerById(id) == null) throw new ResourceNotFoundException();
    }

    public void verifyAccount(Long id) {
        if (accountRepository.findAccountById(id) == null) throw new ResourceNotFoundException();
    }

    // Create
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get
    public Customer getCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

    // Get By Account ID
    public Customer getCustomerByAccountId(Long accountId) {
        // re-work
        return new Customer();
    }

    // Get All
    public List<Customer> getAllCustomers() {
        return (ArrayList<Customer>) customerRepository.findAll();
    }

    // Update
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Delete
    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomerById(id);
    }
}
