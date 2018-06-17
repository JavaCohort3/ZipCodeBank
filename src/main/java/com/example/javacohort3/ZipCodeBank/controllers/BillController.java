package com.example.javacohort3.ZipCodeBank.controllers;


import com.example.javacohort3.ZipCodeBank.domains.Bill;
import com.example.javacohort3.ZipCodeBank.services.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class BillController {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);
    public BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping(value = "/accounts/{accountId}/bills",method = RequestMethod.GET)
    public ResponseEntity<?> getBillByAccountId(@PathVariable Long id) {
        log.info("Getting Bill By Account Id : " + id);
        return new ResponseEntity<>(billService.getAllBillByAccountId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}/bills",method = RequestMethod.GET)
    public ResponseEntity<?> getBillByCustomerId(@PathVariable Long id) {
        log.info("Getting Bill By Customer Id : " + id);
        return new ResponseEntity<>(billService.getBillsByCustomerId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBillById(@PathVariable Long id){
        log.info("Getting Bill By Bill Id : " + id);
        return new ResponseEntity<>(billService.getBillById(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/bills",method = RequestMethod.POST)
    public ResponseEntity<?> createBill (@RequestBody Bill bill,@PathVariable Long id){

        bill = billService.createBill(bill,id);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{accountId}/bills")
                .buildAndExpand(bill.getId())
                .toUri();

        httpHeaders.setLocation(newUri);
        log.info("Creating a bill : " + bill);
        return new ResponseEntity<>(bill,httpHeaders,HttpStatus.OK);

    }

    @RequestMapping(value = "/bills/{billId}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@RequestBody Bill bill, @PathVariable Long id){
        HttpStatus status;
        Bill oldBill = billService.getBillById(id);

        billService.updateBill(bill);

        if (oldBill != null){
            log.info("Bill consist of  : ",oldBill);
            status = HttpStatus.OK;
        }else {
            log.info("Bill didn't exist so created");
            status = HttpStatus.CREATED;
        }
        log.info("Creating a updating Bill : " + bill);
        return new ResponseEntity<>(bill,status);
    }

    @RequestMapping(value = "/bills/{billId}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBill (@PathVariable Long id){
        HttpStatus status;

        billService.deleteBill(id);
        status = HttpStatus.NO_CONTENT;
        log.info("deleted bill : " + id);
        return new ResponseEntity<>(status);
    }

}
