package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class AccountController {
    private AccountService accountService ;

    @Autowired
    public AccountController(AccountService accountService) { this.accountService = accountService;}

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
        HttpStatus status = HttpStatus.CREATED;
        Account a = accountService.createAccount(account);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{}")
                .buildAndExpand(a.getId())
                .toUri();

        httpHeaders.setLocation(newUri);


        return new ResponseEntity<>(a, httpHeaders, status);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long id) {
        HttpStatus status;

        Account old_value = accountService.getAccountById(id);
        accountService.createAccount(account);

        if (old_value != null) {
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.CREATED;
        }

        return new ResponseEntity<>(account, status);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        HttpStatus status = HttpStatus.NO_CONTENT;
        Account account = accountService.getAccountById(id);

        accountService.verifyByAccount(id);
        accountService.deleteAccount(id);

        return new ResponseEntity<>(account, status);
    }
}
