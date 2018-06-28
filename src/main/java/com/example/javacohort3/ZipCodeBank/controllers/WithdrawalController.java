package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Withdrawal;
import com.example.javacohort3.ZipCodeBank.exceptions.DeleteResponse;
import com.example.javacohort3.ZipCodeBank.exceptions.ResponseDetails;
import com.example.javacohort3.ZipCodeBank.services.WithdrawalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WithdrawalController {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    private WithdrawalService withdrawalService;
    private HttpStatus status;

    @Autowired
    public WithdrawalController(WithdrawalService withdrawalService) {
        this.withdrawalService = withdrawalService;
    }

    @RequestMapping("/accounts/{accountId}/withdrawals")
    public ResponseEntity<?> getWithdrawalsByAccountId(@PathVariable Long accountId){
        withdrawalService.verifyAccountById(accountId);
        List<Withdrawal> withdrawals = withdrawalService.getWithdrawalsByAccountId(accountId);

        status = HttpStatus.OK;

        log.info("\n[GET]: " + withdrawals);
        return new ResponseEntity<>(new ResponseDetails(status,"Success",withdrawals), status);
    }

    @RequestMapping("/withdrawals/{withdrawalId}")
    public ResponseEntity<?> getWithdrawlById(@PathVariable Long withdrawalId){
        withdrawalService.verifyWithdrawalById(withdrawalId);
        Withdrawal withdrawal = withdrawalService.getWithdrawalById(withdrawalId);

        status = HttpStatus.OK;
        log.info("\n[GET]: " + withdrawal);
       return new ResponseEntity<>(new ResponseDetails(status,"Success",withdrawal),status);
    }


    @RequestMapping(value = "/accounts/{accountsId}/withdrawals",method = RequestMethod.POST)
    public ResponseEntity<?> createWithdrawlByAccountId(@RequestBody Withdrawal withdrawal, @PathVariable Long accountsId){
        withdrawalService.verifyAccountById(accountsId);
        withdrawalService.createWithdrawal(withdrawal);
        status =   HttpStatus.CREATED;

        log.info("\n[POST]: " + withdrawal);
        return new ResponseEntity<>(new ResponseDetails(status,"Created withdrawal and subtracted it from the account",withdrawal), status);
    }


    @RequestMapping(value = "/withdrawals/{withdrawalId}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateWithdrawl(@PathVariable Long withdrawalId, @RequestBody Withdrawal withdrawal){
        withdrawalService.verifyWithdrawalById(withdrawalId);
        withdrawal.setId(withdrawalId);
        withdrawalService.updateWithdrawal(withdrawal);

        status = HttpStatus.OK;

        log.info("\n[PUT]" + withdrawal);
        return new ResponseEntity<>(new ResponseDetails(status,"Accepted withdrawal modification",withdrawal), status);
    }


    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawalId){
        withdrawalService.verifyWithdrawalById(withdrawalId);
        withdrawalService.deleteWithdrawalById(withdrawalId);

        status = HttpStatus.NO_CONTENT;

        log.info("\n[Deleted]: Withdrawal object");
        return new ResponseEntity<>(new DeleteResponse(status, "Withdrawal successfully deleted."),status);
    }
}
