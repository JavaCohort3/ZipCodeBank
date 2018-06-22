package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Account;

import com.example.javacohort3.ZipCodeBank.services.AccountService;
import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
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
        accountService.verifyAccountById(new Long(1));
        ArrayList<Account> accounts = (ArrayList<Account>) accountService.getAllAccounts();

        log.info("[GET ALL] " + accounts);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // Get account by its ID
    @RequestMapping("/accounts/{accountId}")
    public ResponseEntity<?> getAccountByID(@PathVariable Long accountId){
        accountService.verifyAccountById(accountId);
        Account account = accountService.getAccountById(accountId);

        log.info("[GET] " + account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // Get accounts by customer ID
    @RequestMapping("/customers/{customerId}/accounts")
    public ResponseEntity<?> getAllAccountsByCustomerId(@PathVariable Long customerId) {
        accountService.verifyCustomerById(customerId);
        ArrayList<Account> accounts = (ArrayList<Account>) accountService.getAccountsByCustomerId(customerId);

        accountService.verifyAccountById(new Long(accounts.size()));

        log.info("[GET] " + customerId);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // Create account
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccountFromCustomerId(@RequestBody Account account, @PathVariable Long customerId){
        account.setCustomer(accountService.getCustomerById(customerId));

        Account newAccount = accountService.createAccount(account);
        accountService.verifyAccountById(newAccount.getId());

        log.info("[POST] " + newAccount);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    // Update Account
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public  ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long accountId) {
        HttpStatus status;

        // needs work

        Account oldAccount = accountService.updateAccount(account);


        if(oldAccount.equals(accountService.getAccountById(accountId))){
            // account.setCustomer(new Customer(customerId,null,"","",null));
            Account a = accountService.createAccount(account);
            log.info("[updated]" + account);
            status = HttpStatus.OK;
            return new ResponseEntity<>(a,status);
        }else{
            log.info("[created]" + account);
            status = HttpStatus.CREATED;
            return new ResponseEntity<>(status);
        }


    }

    // Delete account
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleAccountById(@PathVariable Long accountId){
        HttpStatus status = HttpStatus.NO_CONTENT;

        accountService.deleteAccount(accountId);
        log.info("[DELETE] " + accountId);

        return new ResponseEntity<> (status);
    }

}