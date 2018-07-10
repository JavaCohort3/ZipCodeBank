package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Bill;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.BillRepository;
import com.example.javacohort3.ZipCodeBank.util.Burn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    private BillRepository billRepository;
    private AccountRepository accountRepository;

    @Autowired
    public BillService(BillRepository billRepository, AccountRepository accountRepository){
        this.billRepository = billRepository;
        this.accountRepository = accountRepository; }

    public void verifyAccountById(Long id){
        if(accountRepository.findAccountById(id) == null) throw new ResourceNotFoundException(HttpStatus.NOT_FOUND," error fetching bills ");
    }

    public void verifyBillById(Long id){
        if(billRepository.findBillById(id) == null) throw new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Bill ID does not exist");
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

    public List<Bill> getBillsByCustomerId(Long customerId){
        //        ArrayList<Account>  accounts = (ArrayList<Account>) accountRepository.findAll();
        ArrayList<Bill> bills = (ArrayList<Bill>) billRepository.findAll();
        verifyBillById((long) bills.size());

        //        accounts.removeIf(account -> account.getCustomer().getId().equals(customerId));
        //        bills.removeIf(bill -> !bill.getAccountId().equals());
        return bills;
    }

    public Bill updateBill(Bill bill){
    	verifyBillById(bill.getId());
    Bill oldBill = getBillById(bill.getId());
    
    bill = (Bill) Burn.updateObjectFields(bill, oldBill);
    	
    	
    return billRepository.save(bill);
    }

    public void deleteBillById(Long id){
        billRepository.deleteById(id);
    }
}