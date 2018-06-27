package com.example.javacohort3.ZipCodeBank.controllers;


import com.example.javacohort3.ZipCodeBank.domains.Customer;

import com.example.javacohort3.ZipCodeBank.exceptions.ResponseDetails;
import com.example.javacohort3.ZipCodeBank.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    private CustomerService customerService;
    private HttpStatus status;
    private String response;

    @Autowired
    public CustomerController(CustomerService customerService) { this.customerService = customerService; }

    // Get a Customer by their Account ID
    @RequestMapping(value ="/accounts/{accountId}/customer")
    public ResponseEntity<?> getCustomerByAccountId(@PathVariable Long accountId) {
        customerService.verifyAccount(accountId);
        Customer customer = customerService.getCustomerByAccountId(accountId);
        customerService.verifyCustomer(customer.getId());

        status = HttpStatus.OK;
        response = "Success";

        log.info("[GET BY ACCOUNT ID]: " + customer);
        return new ResponseEntity<>(new ResponseDetails(status, response, customer), status);
    }

    // Get all Customers
    @RequestMapping(value = "/customers")
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        customerService.verifyCustomer(new Long(customers.size()));

        status = HttpStatus.OK;
        response = "Success";

        log.info("[GET ALL CUSTOMERS]: " + customers);
        return new ResponseEntity<>(new ResponseDetails(status, response, customers), status);
    }

    // Get Customer By their ID
    @RequestMapping(value = "/customers/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        customerService.verifyCustomer(id);
        Customer customer = customerService.getCustomerById(id);

        status = HttpStatus.OK;
        response = "Success";

        log.info("[GET BY ID]: " + customer);
        return new ResponseEntity<>(new ResponseDetails(status, response, customer), status);
    }

    // Create a new Customer
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody @Valid Customer customer) {
        Customer c = customerService.createCustomer(customer);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id").buildAndExpand(c.getId()).toUri();
        httpHeaders.setLocation(uri);

        status = HttpStatus.CREATED;
        response = "Customer account created.";

        log.info("[POST]: " + c);
        return new ResponseEntity<>(new ResponseDetails(status, response, customer), httpHeaders, status);
    }

    // Update a Customer by their ID
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        customerService.verifyCustomer(id);
        customer.setId(id);
        Customer c = customerService.updateCustomer(customer);

        status = HttpStatus.OK;
        response = "Customer account updated.";

        
        log.info("[PUT]: " + c);
        return new ResponseEntity<>(new ResponseDetails(status, response, customer), status);
    }
}
