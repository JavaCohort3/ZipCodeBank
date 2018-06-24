package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Deposit;
import com.example.javacohort3.ZipCodeBank.exceptions.ResponseDetails;
import com.example.javacohort3.ZipCodeBank.services.DepositService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.format.datetime.joda.ReadablePartialPrinter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DepositController {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);

    private DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService){
        this.depositService = depositService;
    }

    //Get all deposits for an account
    @RequestMapping(value = "/accounts/{accountId}/deposits")
    public ResponseEntity<?> getAllDepositsByAccountId(@PathVariable Long accountId){
        depositService.verifyAccountById(accountId);
        ArrayList<Deposit> deposits = new ArrayList<>();
        depositService.getDepositsByAccountId(new Long(deposits.size()));

        log.info("[GET] " + accountId);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK,"Success",deposits),HttpStatus.OK);
    }

    //Get deposit by id
    @RequestMapping(value = "/deposits/{depositId}")
    public ResponseEntity<?> getDepositById(@PathVariable Long depositId){
        depositService.verifyDepositById(depositId);
        Deposit deposit = depositService.getDepositById(depositId);

        log.info("[GET] " + deposit);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK,"Success", deposit),HttpStatus.OK);
    }

    //Create a deposit
    @RequestMapping(value = "/accounts/{accountId}/deposits")
    public ResponseEntity<?> createDepositFromCustomerId(@RequestBody Deposit deposit, @PathVariable Long accountId ){
    depositService.getDepositsByAccountId(accountId);
    Deposit newDeposit = depositService.createDeposit(deposit);

    log.info("[POST] " + deposit);
    return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK,"Success",deposit),HttpStatus.OK);
    }

    //Update a specific existing deposit
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDeposit(@RequestBody Deposit deposit, @PathVariable Long depositId){
        depositService.verifyDepositById(depositId);
        Deposit updatedDeposit = depositService.updateDeposit(deposit);

        log.info("[UPDATED] " + updatedDeposit);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK,"Success",deposit),HttpStatus.OK);
    }

    //Delete deposit
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId){
        depositService.verifyDepositById(depositId);
        depositService.deleteDeposit(depositId);

        log.info("{DELETED]" + depositId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}