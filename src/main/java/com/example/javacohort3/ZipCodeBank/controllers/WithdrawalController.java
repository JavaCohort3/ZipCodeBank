package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Withdrawal;
import com.example.javacohort3.ZipCodeBank.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@RestController
public class WithdrawalController {
    private WithdrawalService withdrawalService;

    @Autowired
    public WithdrawalController (WithdrawalService withdrawalService){
        this.withdrawalService = withdrawalService;
    }

    //Get ALL (for Account ID)
    @RequestMapping(value ="/accounts/{accountId}/withdrawals", method = RequestMethod.GET)
    public ResponseEntity<?> getAllWithdrawalsForAccountId (@PathVariable Long accountId){
        ArrayList<Withdrawal> withdrawals = withdrawalService.getAllWithdrawalsForAccountId(accountId);
        return new ResponseEntity<>(withdrawals, HttpStatus.OK);
    }

    // Get Withdrawal (By ID)
    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.GET)
    public ResponseEntity<?> getWithdrawalById(@PathVariable Long withdrawalId) {
        withdrawalService.verifyWithdrawal(withdrawalId);

        Withdrawal withdrawal = withdrawalService.getWithdrawalById(withdrawalId);
        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }

    // Create Withdrawal
    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdrawalFromAccount(@RequestBody Withdrawal withdrawal, @PathVariable Long accountId) {
        withdrawalService.verifyAccount(accountId);

        Withdrawal w = withdrawalService.createWithdrawalFromAccount(withdrawal, accountId);
        return new ResponseEntity<>(w, HttpStatus.CREATED);
    }

    // Update Withdrawal
    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDWithdrawalFromAccountId(@RequestBody Withdrawal withdrawal, @PathVariable Long withdrawalId) {
        Withdrawal old_withdrawal = withdrawalService.getWithdrawalById(withdrawalId);
        Withdrawal new_withdrawal = withdrawalService.updateWithdrawal(withdrawal);
        return new ResponseEntity<>(withdrawal, HttpStatus.CREATED);
    }

    // Delete Withdrawal
    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWithdrawalById(@PathVariable Long withdrawalId) {
        withdrawalService.verifyWithdrawal(withdrawalId);

        Withdrawal withdrawal = withdrawalService.getWithdrawalById(withdrawalId);
        withdrawalService.deleteWithdrawal(withdrawalId);
        return new ResponseEntity<>(withdrawal, HttpStatus.NO_CONTENT);
    }
}
