package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Customer;
import com.example.javacohort3.ZipCodeBank.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @RequestMapping(value = "/customer/{customerFirst_Name}/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccounts(@PathVariable String customerFirst_Name) {
        HttpStatus status = HttpStatus.OK;

        List<Account> allAccounts = accountService.getAllAccountsByCustomerFirst_Name(customerFirst_Name);
        log.info("Get accounts");
        return new ResponseEntity<>(allAccounts, status);
    }


    @RequestMapping(value = "customers/{customerId}/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountByID(@PathVariable Long accountId){
        HttpStatus status;
        Object response;
        Account account = accountService.getAccountById(accountId);

        accountService.verifyAccountById(accountId);

        log.info("[Get]" + account);
        status = HttpStatus.OK;
        response = account;

        return new ResponseEntity<>(response, status);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccountsByCustomerId(@PathVariable Long customerId) {
        HttpStatus status = HttpStatus.OK;
        Account customerInfo = accountService.getAccountByCustomerId(customerId);
        log.info("[Get]" + customerId);
        return new ResponseEntity<>(customerInfo, status);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccountFromCustomerId(@RequestBody Account account, @PathVariable Long customerId){
        HttpStatus status = HttpStatus.CREATED;
        account.setCustomer(new Customer(customerId,null,"","",null));
        Account a = accountService.createAccount(account);


        log.info("[POST] " + a);
        return new ResponseEntity<>(a, status);
    }


    @RequestMapping(value = "/customers/{customerId}/accounts/{accountId}", method = RequestMethod.PUT)
    public  ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long customerId ,@PathVariable Long accountId) {
        HttpStatus status;


        Account oldAccount = accountService.updateAccount(account);


        if(oldAccount.equals(accountService.getAccountById(accountId))){
            account.setCustomer(new Customer(customerId,null,"","",null));
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

    @RequestMapping(value = "accounts/{accountId}", method = RequestMethod.PUT)
    public  ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long accountId) {
        Account old_account = accountService.getAccountById(accountId);
        Account new_account = accountService.updateAccount(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/accounts/{accountId", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccountById(@PathVariable Long accountId){

        HttpStatus status = HttpStatus.NO_CONTENT;

        accountService.deleteAccount(accountId);
        log.info("Deleted" + accountId);

        return new ResponseEntity<> (status);
    }
}