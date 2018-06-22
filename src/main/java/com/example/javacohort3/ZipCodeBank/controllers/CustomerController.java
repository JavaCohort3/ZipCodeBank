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

import java.net.URI;
import java.util.List;

@RestController
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) { this.customerService = customerService; }

    // Get a Customer by their Account ID
    @RequestMapping(value ="/accounts/{accountId}/customer", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerByAccountId(@PathVariable Long accountId) {

        customerService.verifyAccount(accountId);
        Customer customer = customerService.getCustomerByAccountId(accountId);
        ResponseDetails responseDetails = new ResponseDetails();

        responseDetails.setCode(HttpStatus.OK.value());
        responseDetails.setMessage("Success");
        responseDetails.setData(customer);

        log.info("[GET BY ACCOUNT ID]: " + customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // Get all Customers
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomers() {

        ResponseDetails responseDetails = new ResponseDetails();
        List<Customer> customers = customerService.getAllCustomers();

        responseDetails.setCode(HttpStatus.OK.value());
        responseDetails.setMessage("Success");
        responseDetails.setData(customers);

        log.info("[GET ALL CUSTOMERS]: " + customers);
        return new ResponseEntity<>(responseDetails, HttpStatus.OK);
    }

    // Get Customer By their ID
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {

        ResponseDetails responseDetails = new ResponseDetails();
        customerService.verifyCustomer(id);
        Customer customer = customerService.getCustomerById(id);

        responseDetails.setCode(HttpStatus.OK.value());
        responseDetails.setMessage("Success");
        responseDetails.setData(customer);

        log.info("[GET BY ID]: " + customer);
        return new ResponseEntity<>(responseDetails, HttpStatus.OK);
    }

    // Create a new Customer
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {

        ResponseDetails responseDetails = new ResponseDetails();
        Customer c = customerService.createCustomer(customer);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newUri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/id")
                .buildAndExpand(c.getId())
                .toUri();
        httpHeaders.setLocation(newUri);

        responseDetails.setCode(HttpStatus.CREATED.value());
        responseDetails.setMessage("Customer created");
        responseDetails.setData(customer);

        log.info("[POST]: " + c);
        return new ResponseEntity<>(responseDetails, HttpStatus.CREATED);
    }

    // Update a Customer by their ID
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        customerService.verifyCustomer(id);
        Customer c = customerService.updateCustomer(customer);
        ResponseDetails responseDetails = new ResponseDetails();

        responseDetails.setCode(HttpStatus.OK.value());
        responseDetails.setMessage("Customer account updated");
        responseDetails.setData(customer);

        log.info("[PUT]: " + c);
        return new ResponseEntity<>(responseDetails, HttpStatus.OK);

    }

    @RequestMapping(value = "/customers/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomer(customerId);

        log.info("[DELETE]: customer with id: " + customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
