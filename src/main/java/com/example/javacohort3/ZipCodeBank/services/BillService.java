package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Bill;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.BillRepository;
import com.example.javacohort3.ZipCodeBank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BillService {
    private BillRepository billRepository;
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;


    @Autowired
    public BillService(BillRepository billRepository, AccountRepository accountRepository){
        this.billRepository = billRepository;
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public void verifyAccountById(Long id){
        if(accountRepository.findAccountById(id) == null) throw new ResourceNotFoundException();
    }

    public void verifyBillById(Long id){
        if(billRepository.findBillById(id) == null) throw new ResourceNotFoundException();
    }

    public Bill createBill(Bill bill){
        return billRepository.save(bill);
    }

    public Bill getBillById(Long id){
        return billRepository.findBillById(id);
    }

    public List<Bill> getAllBillsByAccountId(Long accountId){
        ArrayList<Bill> bills = (ArrayList<Bill>) billRepository.findAll();
        bills.removeIf(b -> !b.getAccountId().equals(accountId));
        return bills;
    }

    public Bill getBillsByCustomerId(Long customerId){
        return billRepository.findAllById(customerId);
    }

    public Bill updateBill(Bill bill){
        return billRepository.save(bill);
    }

    public void deleteBill(Long id){
        billRepository.deleteBillByBillId(id);
    }
}
