package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findAccountById(Long id);
    void deleteAccountById(Long id);
}
