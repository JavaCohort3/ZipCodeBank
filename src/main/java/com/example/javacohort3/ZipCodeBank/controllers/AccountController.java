package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Account;

import com.example.javacohort3.ZipCodeBank.exceptions.ResponseDetails;
import com.example.javacohort3.ZipCodeBank.services.AccountService;
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
import java.util.ArrayList;
import java.util.List;


@RestController
public class AccountController {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    private AccountService accountService;


    @Autowired
    public AccountController(AccountService accountService) { this.accountService = accountService; }

    // Get all accounts
    @RequestMapping("/accounts")
    public ResponseEntity<?> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();

        log.info("[GET ALL] " + accounts);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK,"Success", accounts), HttpStatus.OK);
    }

    // Get account by its ID
    @RequestMapping("/accounts/{accountId}")
    public ResponseEntity<?> getAccountByID(@PathVariable Long accountId){
        accountService.verifyAccountById(accountId);
        Account account = accountService.getAccountById(accountId);

        log.info("[GET] " + account);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK, "Success", account), HttpStatus.OK);
    }

    // Get accounts by customer ID
    @RequestMapping("/customers/{customerId}/accounts")
    public ResponseEntity<?> getAllAccountsByCustomerId(@PathVariable Long customerId) {
        accountService.verifyCustomerById(customerId);
        ArrayList<Account> accounts = (ArrayList<Account>) accountService.getAccountsByCustomerId(customerId);

        accountService.verifyAccountById(new Long(accounts.size()));

        log.info("[GET] " + customerId);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK,"Success", accounts), HttpStatus.OK);
    }

    // Create account
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccountFromCustomerId(@RequestBody Account account, @PathVariable Long customerId){
        accountService.verifyCustomerById(customerId);
        account.setCustomer(accountService.getCustomerById(customerId));

        Account newAccount = accountService.createAccount(account);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newUri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{accountId}")
                .buildAndExpand(newAccount.getId())
                .toUri();
        httpHeaders.setLocation(newUri);

        log.info("[POST] " + newAccount);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.CREATED,"Account successfully created",newAccount), httpHeaders,HttpStatus.CREATED);
    }

    // Update Account
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public  ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long accountId){
        accountService.verifyAccountById(accountId);
        accountService.updateAccount(account);

        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK,"Success",account),HttpStatus.OK);
    }

    // Delete account
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccountById(@PathVariable Long accountId){
        accountService.verifyAccountById(accountId);
        accountService.deleteAccountById(accountId);

        log.info("[DELETE] " + accountId);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.NOT_FOUND,"Account successfully deleted",new Object()),HttpStatus.OK);
    }

}