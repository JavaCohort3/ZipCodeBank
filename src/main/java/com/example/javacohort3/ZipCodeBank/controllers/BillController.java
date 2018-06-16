package com.example.javacohort3.ZipCodeBank.controllers;


import com.example.javacohort3.ZipCodeBank.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BillController {
    @Autowired
    BillService billService;

    @RequestMapping(value = "/accounts/{accountId}/bills")
    ResponseEntity<?> getAllBillByAccountId()
}
