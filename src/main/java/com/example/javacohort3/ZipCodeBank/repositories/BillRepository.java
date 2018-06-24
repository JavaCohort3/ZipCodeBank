package com.example.javacohort3.ZipCodeBank.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BillRepository extends CrudRepository<Bill, Long> {

    Bill findBillById(Long accountId);
    void deleteBillByBillId(Long billId);
}
