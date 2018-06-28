package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Withdrawal;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WithdrawalService {
    private WithdrawalRepository withdrawalRepository;
    private AccountRepository accountRepository;

    @Autowired
    public WithdrawalService(WithdrawalRepository withdrawalRepository, AccountRepository accountRepository) {
        this.withdrawalRepository = withdrawalRepository;
        this.accountRepository = accountRepository;
    }

    public void verifyWithdrawalById(Long id){
        if (withdrawalRepository.findWithdrawalById(id) == null) throw new ResourceNotFoundException(HttpStatus.NOT_FOUND," error fetching withdrawal with id " + id);
    }

    public void verifyAccountById(Long id) {
        if (accountRepository.findAccountById(id) == null) throw new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Account Not Found");
    }


    public Withdrawal createWithdrawal(Withdrawal Withdrawal){
        return withdrawalRepository.save(Withdrawal);
    }

    public List<Withdrawal> getWithdrawalsByAccountId(Long accountId) {
        verifyAccountById(accountId);
        ArrayList<Withdrawal> withdrawals = (ArrayList<Withdrawal>) withdrawalRepository.findAll();
        verifyWithdrawalById(((long) withdrawals.size()));
        withdrawals.removeIf(w -> !w.getPayerId().equals(accountId));
        return withdrawals;
    }

    public Withdrawal getWithdrawalById (Long id){
        return withdrawalRepository.findWithdrawalById(id);
    }

    public Withdrawal updateWithdrawal(Withdrawal Withdrawal){
        return withdrawalRepository.save(Withdrawal);
    }

    public void deleteWithdrawalById(Long id){
        withdrawalRepository.deleteById(id);
    }
}
