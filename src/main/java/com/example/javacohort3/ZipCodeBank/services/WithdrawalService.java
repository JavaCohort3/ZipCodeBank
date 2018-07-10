package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Withdrawal;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.WithdrawalRepository;
import com.example.javacohort3.ZipCodeBank.util.Burn;
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

    public void verifyWithdrawalById(Long id) {
        if (withdrawalRepository.findWithdrawalById(id) == null) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, " error fetching withdrawal with id " + id);
        }
    }
    public void verifyAccountById(Long id) {
        if (accountRepository.findAccountById(id) == null){
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Account Not Found");
        }
    }

    public Withdrawal createWithdrawal(Withdrawal withdrawal){
        verifyAccountById(withdrawal.getPayerId());
        Account account = accountRepository.findAccountById(withdrawal.getPayerId());

        if (account.getBalance() - withdrawal.getAmount() < 0) {
            throw new ResourceNotFoundException(HttpStatus.OK, "Insufficient funds to make withdrawal.");
        }

        return withdrawalRepository.save(withdrawal);
    }

    public List<Withdrawal> getWithdrawalsByAccountId(Long accountId) {
        verifyAccountById(accountId);
        ArrayList<Withdrawal> withdrawals = (ArrayList<Withdrawal>) withdrawalRepository.findAll();
        verifyWithdrawalById(((long) withdrawals.size()));
        withdrawals.removeIf(w -> !w.getPayerId().equals(accountId));
        verifyWithdrawalById((long) withdrawals.size());
        return withdrawals;
    }

    public Withdrawal getWithdrawalById (Long id){
        verifyWithdrawalById(id);
        return withdrawalRepository.findWithdrawalById(id);
    }

    public Withdrawal updateWithdrawal(Withdrawal withdrawal){
        verifyWithdrawalById(withdrawal.getId());
        Withdrawal oldWithdrawal = getWithdrawalById(withdrawal.getId());
        withdrawal = (Withdrawal) Burn.updateObjectFields(withdrawal, oldWithdrawal);
        return withdrawalRepository.save(withdrawal);
    }

    public void deleteWithdrawalById(Long id){
        verifyWithdrawalById(id);
        withdrawalRepository.deleteById(id);
    }
}
