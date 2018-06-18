package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Withdrawal;
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
    public WithdrawalService(AccountRepository accountRepository, WithdrawalRepository withdrawalRepository) {
        this.accountRepository = accountRepository;
        this.withdrawalRepository = withdrawalRepository;
    }

    public void verifyWithdrawal(Long withdrawalId){
        if(withdrawalRepository.findById(withdrawalId).orElse(null) == null) throw new ResourceNotFoundException();
    }

    public void verifyAccount(Long accountId){
        if(accountRepository.findById(accountId).orElse(null) == null) throw new ResourceNotFoundException();
    }

    public Withdrawal createWithdrawalFromAccount (Withdrawal withdrawal, Long accountId) {
        Account account = accountRepository.findById(accountId).orElse(null);
        account.setBalance(account.getBalance() - withdrawal.getAmount());
        accountRepository.save(account);

        // binds account ID to deposit
        withdrawal.setAccount_id(accountId);
        return withdrawalRepository.save(withdrawal);
    }

    public Withdrawal getWithdrawalById (Long id){
        return withdrawalRepository.findById(id).orElse(null);
    }

    public ArrayList<Withdrawal> getAllWithdrawalsForAccountId (Long accountId){
        ArrayList<Withdrawal> withdrawals = new ArrayList<>();
        withdrawalRepository.findAll().forEach(withdrawal -> {
            if (withdrawal.getAccount_id() == accountId) {
                //adds withdrawal to the list if account is the account specified
                withdrawals.add(withdrawal);
            }
        });
        return withdrawals;
    }

    public Withdrawal updateWithdrawal (Withdrawal withdrawal){
        return withdrawalRepository.save(withdrawal);
    }

    public void deleteWithdrawal (Long id){
        withdrawalRepository.deleteById(id);
    }
}
