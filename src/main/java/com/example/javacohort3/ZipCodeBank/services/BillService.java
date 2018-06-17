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

    public BillService() {
    }

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public void verifyByBillId(Long id){
     if (billRepository.findById(id).orElse(null) == null){
         //throw new ResourceNotFoundException;
     }
    }


    public Bill createBill(Bill bill, Long id){return billRepository.save(bill); }


    public Bill getBillById(Long id){
        return billRepository.findById(id).orElse(null);
    }


    public ArrayList<Bill> getAllBillByAccountId(Long id){
        ArrayList<Bill> listOfAllBill = (ArrayList<Bill>) billRepository.findAll();
        for (Bill b : listOfAllBill)
        {
            if (b.getAccount_id().equals(id)){
                billRepository.findById(b.getId());
            }else {
                //throw new ResourceNotFoundException();
            }
        }
        return null;
    }


    public ArrayList<Bill> getBillsByCustomerId(Long id){
        ArrayList<Bill> listOfAllBill = (ArrayList<Bill>) billRepository.findAll();
        for (Bill b : listOfAllBill)
        {
            if (b.getId().equals(id)){
                billRepository.findById(b.getId());
            }else {
               // throw new ResourceNotFoundException();
            }
        }
        return null;
    }


    public Bill updateBill(Bill bill){
        return billRepository.save(bill);
    }


    public void deleteBill(Long id){
        billRepository.deleteById(id);
    }


}
