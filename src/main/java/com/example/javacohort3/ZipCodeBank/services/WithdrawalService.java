package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WithdrawalService {
    private WithdrawalRepository withdrawalRepository;
    private AccountRepository accountRepository;

    @Autowired
    public WithdrawalService(WithdrawalRepository withdrawalRepository, AccountRepository accountRepository) {
        this.withdrawalRepository = withdrawalRepository;
        this.accountRepository = accountRepository;
    }

    //Verify
    public void verifyAccount(Long accountId){
        if(accountRepository.findAccountById(accountId) == null) throw new ResourceNotFoundException();
    }

    //Verify
    public void verifyWIthdrawal(Long id){
        if(withdrawalRepository.findById(id) == null) throw new ResourceNotFoundException();
    }

    //Create
    public Withdrawal createWithdrawal (Withdrawal withdrawal){
        return withdrawalRepository.save(withdrawal);
    }

    //Get by Id
    public Withdrawal getWithdrawalById (Long id){
        return withdrawalRepository.getWithdrawalById(id);
    }

    //Get all by Account Id
    public ArrayList<Withdrawal> getAllWithdrawalsForAccountId (Long accountId){
        return (ArrayList<Withdrawal>) withdrawalRepository.findAll();
    }

    //Update
    public Withdrawal updateWithdrawal (Withdrawal withdrawal){
        return withdrawalRepository.save(withdrawal);
    }

    //Delete
    public void deleteWithdrawal (Long id){
        withdrawalRepository.deleteById(id);
    }

}
