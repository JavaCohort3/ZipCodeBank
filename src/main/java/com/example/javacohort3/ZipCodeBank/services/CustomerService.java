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

    @Autowired
    private CustomerRepository customerRepository;

    // Verify our Customers Id exists
    public void verifyCustomer(Long id) {
        if (customerRepository.findById(id).orElse(null) == null) {
            throw new ResourceNotFoundException();
        }
    }

    // Create a new Customer
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get Customer by their Account ID
    public Customer getCustomerByAccountId(Long accountId) {
       return customerRepository.findByAccountId(accountId);
    }


    public List<Customer> getAllCustomers() {
       return (List<Customer>) customerRepository.findAll();
    }

    // Get Customer By their ID
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    // Update a customer
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId){
        customerRepository.deleteById(customerId);
    }
}
