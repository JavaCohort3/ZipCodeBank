package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Customer;
import com.example.javacohort3.ZipCodeBank.repositories.CustomerRepository;
import com.example.javacohort3.ZipCodeBank.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@RestController
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService; }


    // Get Customer By Account ID
    @RequestMapping(value = "/accounts/{accountId}/customer", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerByAccountId(@PathVariable Long accountId) {
        Customer customer = customerService.getCustomerByAccountId(id);

        log.info("[GET] " + customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    // Get All Customers
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomers() {
        ArrayList<Customer> customers = customerService.getCustomers();

        log.info("[GET] " + customers);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Get Customer By ID
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        HttpStatus status = HttpStatus.OK;
        Customer customer = customerService.getCustomerById(id);

        // throw errors if customer is null

        log.info("[GET] " + customer);
        return new ResponseEntity<>(customer, status);
    }

    // Create a new Customer
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@ResponseBody Customer customer) {
        HttpStatus status = HttpStatus.CREATED;
        Customer c = customerService.createCustomer(customer);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getId())
                .toUri();

        httpHeaders.setLocation(newUri);

        log.info("[POST] " + c);
        return new ResponseEntity<>(c, status);
    }

    // Update an existing Customer
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@ResponseBody Customer customer, @PathVariable Long id) {
        HttpStatus status;

        Customer oldCustomer = customerService.getPerson(id);
        customerService.updateCustomer(customer);

        if (oldCustomer != null) {
            // if person did exist prior
            log.info("[PUT-UPDATE] " + customer);
            status = HttpStatus.OK;
        } else {
            // ENTER CODE HERE
            //   to make an error and not create a new customer
            log.info("[ERROR] No Customer found!\nCan not complete request");
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(customer, status);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        HttpStatus status = HttpStatus.NO_CONTENT;
        Customer customer = customerService.getCustomer(id);

        //Enter Code here

        customerService.deleteCustomer(id);
        log.info("[DELETE] Deleted ID - " + id);
        return new ResponseEntity<>(customer, status);
    }

}
