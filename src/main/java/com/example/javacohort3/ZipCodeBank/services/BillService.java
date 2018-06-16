package com.example.javacohort3.ZipCodeBank.services;


import com.example.javacohort3.ZipCodeBank.domains.Bill;
import com.example.javacohort3.ZipCodeBank.domains.Customer;
import com.example.javacohort3.ZipCodeBank.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;


    void verifyByBillId(Long id){
     if (billRepository.findById(id).orElse(null) == null){
         //throw new ResourceNotFoundException;
     }
    }


    Bill createBillByAccountId(Bill bill, Long id){return billRepository.save(bill); }


    Bill getBillById(Long id){
        return billRepository.findById(id).orElse(null);
    }


    ArrayList<Bill> getAllBillByAccountId(Long id){
        ArrayList<Bill> listOfAllBill = (ArrayList<Bill>) billRepository.findAll();
        for (Bill b : listOfAllBill)
        {
            if (billRepository.getBillById(id).getAccount_id().equals(b.getId())){
                billRepository.findById(id);
            }else {
                throw new ResourceNotFoundException();
            }
        }
        return null;
    }


    ArrayList<Bill> getBillsByCustomerId(Long id, Customer customer){
        ArrayList<Bill> listOfAllBill = (ArrayList<Bill>) billRepository.findAll();
        for (Bill b : listOfAllBill)
        {
            if (customer.getId().equals(b.getId())){
                billRepository.findById(id);
            }else {
                throw new ResourceNotFoundException();
            }
        }
        return null;
    }


    Bill updateBill(Bill bill){
        return billRepository.save(bill);
    }


    void deleteBill(Long id){
        billRepository.deleteById(id);
    }


}
