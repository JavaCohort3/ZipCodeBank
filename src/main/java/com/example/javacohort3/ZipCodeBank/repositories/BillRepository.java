package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Bill;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BillRepository extends CrudRepository<Bill,Long> {


//        Bill findBillByAccountId(Bill bill, Long id);
//        Bill getBillById(Long id);
//        ArrayList<Bill> getAllBill();
//        ArrayList<Bill> getBillsByCustomerId(Long id);
//        Bill updateBill(Bill bill);
//        void deleteBill(Long id);

}
