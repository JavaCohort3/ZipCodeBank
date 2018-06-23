package com.example.javacohort3.ZipCodeBank.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BillRepository extends CrudRepository<Bill, Long> {

    ArrayList<Bill> findBillsByAccountId(Long AccountId);
    void deleteBillByBillId(Long billId);
}
