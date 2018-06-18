package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Customer;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
        for (Customer c : customerRepository.findAll()) {
            if(c.getAccountId().equals(accountId)) {
                return c;
            }
//             somehow have code to call the account Id
//               might need to extend or autowire the accountRepoonce its made
        }
        throw new ResourceNotFoundException();
    }

    // Get all of our customers //TODO ---- DONE -----
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customer = new ArrayList<>();
        customerRepository.findAll().forEach(customer::add);

        return customer;
    }

    // Get Customer By their ID
    public Customer getCustomerById(Long id) {
        return customerRepository.getCustomerById(id);
    }

    // Update a customer
    public Customer updateCustomer(Customer customer, Long id) {
        return customerRepository.updateCustomer(customer);
    }

}
