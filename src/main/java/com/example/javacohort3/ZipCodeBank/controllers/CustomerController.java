package com.example.javacohort3.ZipCodeBank.controllers;


import com.example.javacohort3.ZipCodeBank.domains.Customer;
import com.example.javacohort3.ZipCodeBank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CustomerController {
    private CustomerRepository customerRepository;

    @Autowired
    public AccountController(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }

    // Get Customer By ID
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        Customer customer = customerRepository.getCustomerById(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // Get Customer By Account ID
    @RequestMapping(value = "/accounts/{accountId}/customer", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerByAccountId(@PathVariable Long accountId) {
        Customer customer = customerRepository.getCustomerByAccountId(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // Get All Customers
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomers() {
        ArrayList<Customer> customers = customerRepository.getCustomers();

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
