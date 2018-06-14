package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Bill;
import com.example.javacohort3.ZipCodeBank.service.AccountService;
import com.example.javacohort3.ZipCodeBank.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BillController {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    private BillService billService;

    @Autowired
    public BillController(BillService billService){
        this.billService = billService;
    }

    @RequestMapping(value = "/accounts/{accountid}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getBillsByAccountId(@PathVariable Long accountId) {
        HttpStatus status;
        Object response;
        ArrayList<Bill> bills = billService.getBillsByAccountId(accountId);

            if(bills != null){
                //at least one bill exists
                log.info("[GET] " + bills);
                status = HttpStatus.OK;
                response = bills;
            }else{
                // bill does not exist
                log.info("[GET-FAILED] ID-" + accountId);
                status = HttpStatus.NOT_FOUND;
                response = "Bill with ID " + accountId + " does not exist.";
            }

        return new ResponseEntity<>(response, status);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBillbyId(@PathVariable Long id) {
        HttpStatus status;
        Object response;
        Bill bill = billService.getBillById(id);

        if (bill != null) {
            // bill exists
            log.info("[GET] " + bill);
            status = HttpStatus.OK;
            response = bill;
        } else {
            // bill does not exist
            log.info("[GET-FAILED] ID-" + id);
            status = HttpStatus.NOT_FOUND;
            response = "Bill with ID " + id + " does not exist.";
        }

        return new ResponseEntity<>(response, status);
    }

    @RequestMapping(value = "/customers/{customerId}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getBillbyCustomerId(@PathVariable Long customerId) {
        HttpStatus status;
        Object response;
        ArrayList<Bill> bills = billService.getBillbyCustomerId(customerId);

        if (bills != null) {
            // bills exist
            log.info("[GET] " + bills);
            status = HttpStatus.OK;
            response = bills;
        } else {
            // bills do not exist
            log.info("[GET-FAILED] ID-" + customerId);
            status = HttpStatus.NOT_FOUND;
            response = "Bills with customer ID " + customerId + " do not exist.";
        }

        return new ResponseEntity<>(response, status);
    }
 }


























