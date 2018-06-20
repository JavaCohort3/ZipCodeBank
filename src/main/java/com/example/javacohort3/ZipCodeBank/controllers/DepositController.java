package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Deposit;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.services.DepositService;
import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DepositController {
    @Autowired
    private DepositService depositService;

    public DepositController () {}

    // Get All (For Account ID)
    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public ResponseEntity<?> getAllDepositsForAccountId(@PathVariable Long accountId) {
        List<Deposit> deposits = depositService.getAllDepositsForAccountId(accountId);
        return new ResponseEntity<>(deposits, HttpStatus.OK);
    }

    // Get Deposit (By ID)
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDepositById(@PathVariable Long depositId) {
        Deposit deposit = depositService.getDepositById(depositId);
        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }

    // Create Deposit
    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDepositFromAccountId(@RequestBody Deposit deposit, @PathVariable Long accountId) {


        Deposit d = depositService.createDepositByFromAccountId(deposit, accountId);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }


    // Update Deposit
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDeposit(@RequestBody Deposit deposit, @PathVariable Long depositId) {
        HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor hasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor = new HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor();
        Boolean isNew = hasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor.wellHasItThen();

        try {
            // deposit already exists
            depositService.verifyDeposit(depositId);
        } catch (ResourceNotFoundException rnfe) {
            // deposit was non-existent
            isNew = true;
        }

        return new ResponseEntity<>(deposit, isNew ? HttpStatus.CREATED : HttpStatus.OK);
    }


    // Delete Deposit
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDepositById(@PathVariable Long depositId) {


        // Deposit deposit = depositService.getDepositById(depositId);
        depositService.deleteDeposit(depositId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
