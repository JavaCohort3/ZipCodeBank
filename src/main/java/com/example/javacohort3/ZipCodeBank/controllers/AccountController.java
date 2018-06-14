package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Customer;
import com.example.javacohort3.ZipCodeBank.service.AccountService;
import com.example.javacohort3.ZipCodeBank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) { this.accountService = accountService; }

    // Get All Accounts
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccounts() {
        ArrayList<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // Get Account By ID
    @RequestMapping(value = "/accounts{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccount(@PathVariable Long accountId) {
        Account account = accountService.getAccountById(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // [Incomplete] todo - Get Accounts By Customer ID
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerAccounts(@RequestBody @PathVariable Long customerId) {
        Account account = new Account(); // accountService.createAccount(customerId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // [Incomplete] todo - Create Account By Customer ID
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody @PathVariable Long customerId) {
        Account account = new Account(); // accountService.createAccount(customerId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // Update Account By ID
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@RequestBody @PathVariable Long accountId) {
        Account account = accountService.updateAccount(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId) {
        Account account = accountService.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
