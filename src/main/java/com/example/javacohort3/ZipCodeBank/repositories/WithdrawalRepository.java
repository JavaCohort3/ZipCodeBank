package com.example.javacohort3.ZipCodeBank.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long> {

    Withdrawal createWithdrawalFromAccountId (Withdrawal withdrawal, Long accountId);
    Withdrawal getWithdrawalById (Long id);
    ArrayList<Withdrawal> getAllWithdrawalsForAccountId (Long accountId);
    Withdrawal updateWithdrawal (Withdrawal withdrawal, Long id);
    void deleteWithdrawal (Long Id);

}
