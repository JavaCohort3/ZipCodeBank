package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Withdrawal;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long> {
    Withdrawal findWithdrawalById (Long id);

}
