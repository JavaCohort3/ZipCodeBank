package com.example.javacohort3.ZipCodeBank.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DepositRepository extends CrudRepository<Deposit, Long> {
    Deposit createDepositByAccountId(Deposit, Long);
    Deposit getDepositById(Long);
    ArrayList<Deposit> getAllDepositsForAccountId(Long);
    Deposit updateDeposit(Deposit, Long);
    void deleteDeposit(Long);
}
