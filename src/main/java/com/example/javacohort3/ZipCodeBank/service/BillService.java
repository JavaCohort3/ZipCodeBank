package com.example.javacohort3.ZipCodeBank.service;

import com.example.javacohort3.ZipCodeBank.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

}
