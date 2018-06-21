package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Customer;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
        public Account findAccountByCustomerId(Long customerId);
        public List<Account> findByCustomerFirstName(String customerFirstName);
        boolean existsByAccountId(Long accountId);
}