package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Deposit;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DepositRepository extends CrudRepository<Deposit, Long> {
    Deposit saveDepositByAccountId(Deposit deposit, Long accountId);
    Deposit findDepositById(Long depositId);
    ArrayList<Deposit> findDepositsByAccountId(Long accountId);
    Deposit saveDeposit(Deposit deposit);
    void deleteDepositById(Long depositId);
}