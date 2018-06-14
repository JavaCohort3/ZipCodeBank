package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Bill;
import com.example.javacohort3.ZipCodeBank.domains.Customer;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Long> {

    Bill getBillById (Long id);

    Bill getBillByAccountId (Account account, Long id);

    Bill getBillByCustomer (Customer customer, Long id);

    Bill updateBill (Bill bill);

    void deleteBill (Long id);

    Bill createBill (Bill bill);
}
