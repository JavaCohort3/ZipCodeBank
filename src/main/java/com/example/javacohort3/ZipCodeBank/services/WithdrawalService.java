package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Withdrawal;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (withdrawalRepository.findWithdrawalById(id) == null) throw new ResourceNotFoundException();
    }

    public void verifyAccountById(Long id) {
        if (accountRepository.findAccountById(id) == null) throw new ResourceNotFoundException();
    }

    public Withdrawal createWithdrawal(Withdrawal Withdrawal){
        return withdrawalRepository.save(Withdrawal);
    }

    public List<Withdrawal> getWithdrawalsByAccountId(Long accountId) {
        ArrayList<Withdrawal> withdrawals = (ArrayList<Withdrawal>) withdrawalRepository.findAll();
        withdrawals.removeIf(d -> !d.getPayerId().equals(accountId));
        return withdrawals;
    }

    public Withdrawal getWithdrawalById (Long id){
        return withdrawalRepository.findWithdrawalById(id);
    }

    public Withdrawal updateWithdrawal(Withdrawal Withdrawal){
        return withdrawalRepository.save(Withdrawal);
    }

    public void deleteWithdrawal(Long id){
        withdrawalRepository.deleteById(id);
    }
}
