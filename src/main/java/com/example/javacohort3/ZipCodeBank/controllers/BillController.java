package com.example.javacohort3.ZipCodeBank.controllers;
import com.example.javacohort3.ZipCodeBank.domains.Bill;
import com.example.javacohort3.ZipCodeBank.exceptions.DeleteResponse;
import com.example.javacohort3.ZipCodeBank.exceptions.ResponseDetails;
import com.example.javacohort3.ZipCodeBank.services.BillService;
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
public class BillController {

    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    private BillService billService;


    @Autowired
    public  BillController(BillService billService){
        this.billService = billService;
    }

    @RequestMapping("/accounts/{accountId}/bills")
    public ResponseEntity<?> getAllBillsByAccountId(@PathVariable Long accountId){
        billService.verifyAccountById(accountId);
        ArrayList<Bill> bills = (ArrayList<Bill>) billService.getAllBillsByAccountId(accountId);

        log.info("[GET]" + accountId);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK, "success", bills), HttpStatus.OK);
    }

    @RequestMapping("/bills/{billId}")
    public ResponseEntity<?> getBillById(@PathVariable Long billId){
        billService.verifyBillById(billId);
        Bill bill = billService.getBillById(billId);

        log.info("[Get]" + bill);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK, "Success", bill), HttpStatus.OK);
    }

    @RequestMapping("/customers/{customerId}/bills")
    public ResponseEntity<?> getBillsByCustomerId(@PathVariable Long customerId){
        List<Bill> bill = billService.getBillsByCustomerId(customerId);

        log.info("[GET BY CUSTOMER ID]" + bill);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK, "Success", bill), HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> createBillFromAccountld(@RequestBody Bill bill, @PathVariable Long accountId){
        bill.setAccountId(accountId);
        Bill newBill = billService.createBill(bill);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newUri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{billId}")
                .buildAndExpand(newBill.getId())
                .toUri();
        httpHeaders.setLocation(newUri);

        log.info("\n[POST] " + newBill);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.CREATED, "Bill Successfully created", newBill ), httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBillById(@RequestBody Bill bill, @PathVariable Long billId){
        billService.verifyBillById(billId);
        bill.setId(billId);
        bill.setAccountId(billService.getBillById(billId).getAccountId());
        Bill updatedBill = billService.updateBill(bill);
        log.info("\n[UPDATED] " + updatedBill);
        return new ResponseEntity<>(new ResponseDetails(HttpStatus.OK, "Success", updatedBill), HttpStatus.OK);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBillById(@PathVariable Long billId){
        billService.deleteBillById(billId);

        log.info("\n[DELETED] " + billId);
        return new ResponseEntity<>(new DeleteResponse(HttpStatus.NO_CONTENT, "Bill successfully deleted."),HttpStatus.ACCEPTED);
    }

}
