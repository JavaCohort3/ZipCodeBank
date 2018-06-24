package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Deposit;
import com.example.javacohort3.ZipCodeBank.exceptions.ResponseDetails;
import com.example.javacohort3.ZipCodeBank.services.DepositService;
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
public class DepositController {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    private DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService){
        this.depositService = depositService;
    }

    //Get all deposits for an account
    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public ResponseEntity<?> getAllDepositsByAccountId(@PathVariable Long accountId){
        depositService.verifyAccountById(accountId);
        List<Deposit> deposits = depositService.getDepositsByAccountId(accountId);
        depositService.verifyDepositById(new Long(1));

        log.info("\n[GET] " + deposits);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK,"Success", deposits),HttpStatus.OK);
    }

    //Get deposit by id
    @RequestMapping(value = "/deposits/{depositId}")
    public ResponseEntity<?> getDepositById(@PathVariable Long depositId){
        depositService.verifyDepositById(depositId);
        Deposit deposit = depositService.getDepositById(depositId);

        log.info("\n[GET] " + deposit);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK,"Success",deposit), HttpStatus.OK);
    }

    //Create a deposit
    @RequestMapping(value = "/accounts/{accountId}/deposits",method = RequestMethod.POST)
    public ResponseEntity<?> createDepositFromAccountId(@RequestBody Deposit deposit, @PathVariable Long accountId ){
        depositService.verifyAccountById(accountId);
        Deposit newDeposit = depositService.createDeposit(deposit);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newUri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{depositId}")
                .buildAndExpand(newDeposit.getId())
                .toUri();
        httpHeaders.setLocation(newUri);

        log.info("\n[POST] " + newDeposit);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.CREATED,"Success",newDeposit),HttpStatus.CREATED);
    }

    //Update a specific existing deposit
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDeposit(@RequestBody Deposit deposit, @PathVariable Long depositId){
        depositService.verifyDepositById(depositId);
        Deposit updatedDeposit = depositService.updateDeposit(deposit);

        log.info("\n[UPDATED] " + updatedDeposit);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK,"Success",updatedDeposit),HttpStatus.OK);
    }

    //Delete deposit  -----NEEDS WORK
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId){
        depositService.verifyDepositById(depositId);
        depositService.deleteDeposit(depositId);

        log.info("\n{DELETED]" + depositId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}