package com.example.javacohort3.ZipCodeBank.services;


import com.example.javacohort3.ZipCodeBank.domains.Bill;
import com.example.javacohort3.ZipCodeBank.domains.Customer;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private AccountRepository accountRepository;
    public BillService() {
    }

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public void verifyByBillId(Long id)throws ResourceNotFoundException{
     if (billRepository.findById(id).orElse(null) == null){
         throw new ResourceNotFoundException();
     }
    }


    public Bill createBill(Bill bill, Long accountId){
        if (accountRepository.existsByAccountId(accountId)){
            return billRepository.save(bill);
        }else {
            throw new ResourceNotFoundException();
        }
    }


    public Bill getBillById(Long billId){
        return billRepository.findById(billId).orElse(null);
    }


    public List<Bill> getAllBillByAccountId(Long accountId){
        List<Bill> billList = new ArrayList<>();
            billRepository.findByAccountId(accountId).forEach(billList::add);
            return billList;
    }


    public List<Bill> getBillsByCustomerId(Long customerId){
        List<Bill> billList = new ArrayList<>();
        billRepository.findByCustomerId(customerId).forEach(billList::add);
        return billList;
    }


    public Bill updateBill(Bill bill){
        return billRepository.save(bill);
    }


    public void deleteBill(Long id){
        billRepository.deleteById(id);
    }


}
