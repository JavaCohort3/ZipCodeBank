package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.services.AccountService;
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


@RestController
public class AccountController {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }



    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccounts() {
        HttpStatus status = HttpStatus.OK;

        ArrayList<Account> account = accountService.getAllAccounts();

        log.info("Get accounts");
        return new ResponseEntity<>(account, status);
    }


    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountByID(@PathVariable Long accountId){

        log.info("[Get]" + accountId);

        return new ResponseEntity<>(accountService.getAccountById(accountId), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccountsByCustomerId(@PathVariable Long customerId) {
        HttpStatus status = HttpStatus.OK;
        accountService.getAllAccountsByCustomerId(customerId);
            log.info("[Get]" + customerId);
        return new ResponseEntity<>(customerId, status);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccountFromCustomerId(@RequestBody Account account, @PathVariable Long customerId){
        HttpStatus status = HttpStatus.CREATED;

        Account a = accountService.createAccountFromCustomerId(account, customerId);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{customerId}/accounts")
                .buildAndExpand(a.getId())
                .toUri();

        httpHeaders.setLocation(newUri);

        log.info("[POST] " + a);
        return new ResponseEntity<>(a, httpHeaders, status);
    }

    @RequestMapping(value = "accounts/{accountId}", method = RequestMethod.PUT)
    public  ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long accountId) {
        Account old_account = accountService.getAccountById(accountId);
        Account new_account = accountService.updateAccount(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/accounts/{accountId", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccountById(@PathVariable Long accountId){
        HttpStatus status = HttpStatus.NO_CONTENT;
        Account account = accountService.getAccountById(accountId);

        accountService.deleteAccountById(accountId);
        log.info("Deleted" + accountId);

        return new ResponseEntity<>(account, status);
    }

}