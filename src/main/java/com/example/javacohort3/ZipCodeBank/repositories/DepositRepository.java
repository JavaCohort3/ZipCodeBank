package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Deposit;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DepositRepository extends CrudRepository<Deposit, Long> {
    // not sure of the methods

    Deposit createDepositByAccountId(Deposit deposit);
    Deposit GetDepositById(Long depositId);
    ArrayList<Deposit> getAllDepositsForAccountId(Long accountId);
    Deposit updateDeposit(Deposit deposit, Long accountId);
    void deleteDeposit(Long depositId);
}