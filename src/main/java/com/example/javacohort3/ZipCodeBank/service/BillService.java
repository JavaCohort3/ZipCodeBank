package com.example.javacohort3.ZipCodeBank.service;


import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Bill;
import com.example.javacohort3.ZipCodeBank.domains.Customer;
import com.example.javacohort3.ZipCodeBank.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    // GET.METHOD for Get all bills for a specific account
    public Bill getBillById (Long id){
        return billRepository.getBillById(id);
        //return billRepository.findById(id).orElse(null);
    }

    // GET.METHOD for Get bill by id
    public Bill getBillByAccountId (Account account, Long id){
       return billRepository.getBillByAccountId(account, id);
//        if (account.getId().equals(id)){
//           return billRepository.findById(id).orElse(null);
//        }else {
//            throw new RuntimeException(); //This could be custom Exception
//        }
    }

    public Bill getBillByCustomer (Customer customer, Long id){
       return billRepository.getBillByCustomer(customer,id);
//        if (customer.getId().equals(id)){
//            return billRepository.findById(id).orElse(null);
//        }else{
//            throw new RuntimeException(); //This could be custom Exception
//        }
    }

    public Bill createBill (Bill bill){
        return billRepository.save(bill);
    }

    public Bill updateBill (Bill bill){
        return billRepository.save(bill);
    }

    public void deleteBill (Long id){
        billRepository.deleteById(id);
    }

}
