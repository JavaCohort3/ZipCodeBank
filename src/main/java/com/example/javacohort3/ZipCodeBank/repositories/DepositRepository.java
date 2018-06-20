package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Deposit;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface DepositRepository extends CrudRepository<Deposit, Long> {

    //public Deposit saveByAccountId(Deposit deposit,Long accountId);
    public List<Deposit> findByAccountId(Long accountId);

}

