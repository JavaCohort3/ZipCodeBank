package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Deposit;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DepositRepository extends CrudRepository<Deposit, Long> {
     ArrayList<Deposit>findDepositByAccountId(Long accountId);
     void deleteDepositById(Long depositId);

}
