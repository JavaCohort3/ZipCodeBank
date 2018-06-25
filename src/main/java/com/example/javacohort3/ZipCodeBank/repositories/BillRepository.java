package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Bill;
import org.springframework.data.repository.CrudRepository;


public interface BillRepository extends CrudRepository<Bill, Long> {

    Bill findBillById(Long accountId);
    void deleteBillById(Long id);
}
