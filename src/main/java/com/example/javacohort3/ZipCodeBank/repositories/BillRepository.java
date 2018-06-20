package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Bill;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface BillRepository extends CrudRepository<Bill,Long> {
        List<Bill> findByCustomerId(Long customerId);
        List<Bill> findByAccountId(Long accountId);

}
