package com.example.javacohort3.ZipCodeBank.controllers;

import com.example.javacohort3.ZipCodeBank.domains.Bill;
import com.example.javacohort3.ZipCodeBank.exceptions.ResponseDetails;
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
        ArrayList<Bill> bills = (ArrayList<Bill>) billService.getBillsByAccountId(accountId);

        billService.verifyBillById(new Long(bills.size()));

        log.info("[Grt]" + accountId);
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
        billService.verifyCustomer(customerId);
        Bill bill = billService.getBillsByCustomerId(customerId);
        billService.verifyBill(bill.getId());

        status = HttpStatus.OK;
        response = "Success";

        log.info("[GET BY CUSTOMER ID" + bill);
        return new ResponseEntity<>(new ResponseDetails(status, response, bill), status);
    }

    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> createBillFromAccountld(@RequestBody Bill bill, @PathVariable Long accountId){
        billService.getBillsByAccountId(accountId);
        Bill newBill = billService.createBill(bill);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newUri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{billId}")
                .buildAndExpand(newBill.getId())
                .toUri();
        httpHeaders.setLocation(newUri);

        status = HttpStatus.CREATED;
        response.setCode(status);
        response.setMessage("Success");
        response.setData(newBill);

        log.info("\n[Post] " + newBill);
        return new ResponseEntity<>(response, status);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBillById(@RequestBody Bill bill, @PathVariable Long billId){
        billService.verifyBillById(billId);
        Bill updatedBill = billService.updateBill(bill);

        status = HttpStatus.OK;
        response.setCode(status);
        response.setMessage("Success");
        response.setData(updatedBill);

        log.info("\n[UPDATED] " + updatedBill);

        return new ResponseEntity<>(response, status);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBillById(@PathVariable Long billId){
        billService.deleteBill(billId);

        status = HttpStatus.NO_CONTENT;
        response.setCode(HttpStatus.NO_CONTENT);
        response.setMessage("Bill successfully deleted");

        log.info("\n[DELETED] " + billId);
        return new ResponseEntity<>(response, status);
    }

}