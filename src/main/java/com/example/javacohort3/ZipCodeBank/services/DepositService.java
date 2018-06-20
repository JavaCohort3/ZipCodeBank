package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Deposit;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepositService {
    private AccountRepository accountRepository;
    private DepositRepository depositRepository;

    @Autowired
    public DepositService(AccountRepository accountRepository, DepositRepository depositRepository) {
        this.accountRepository = accountRepository;
        this.depositRepository = depositRepository;
    }

    public void verifyAccount(Long accountId) {
        if (accountRepository.findById(accountId).orElse(null) == null) throw new ResourceNotFoundException();
    }

    public void verifyDeposit(Long depositId) {
        if (depositRepository.findById(depositId).orElse(null) == null) throw new ResourceNotFoundException();
    }

    public Deposit createDepositByFromAccountId(Deposit deposit, Long accountId) {
        return depositRepository.saveDepositByAccountId(deposit, accountId);
    }

    public Deposit getDepositById(Long id) {
        return depositRepository.findDepositById(id);
    }

    public ArrayList<Deposit> getAllDepositsForAccountId(Long accountId) {
        return depositRepository.findDepositsByAccountId(accountId);
//        ArrayList<Deposit> deposits = new ArrayList<>();
//        depositRepository.findAll().forEach(deposit -> {
//            if (deposit.getAccount_id() == accountId) {
//                // adds deposit to list if account is the account specified
//                deposits.add(deposit);
//            }
//        });
//        return deposits;
    }

    public Deposit updateDeposit(Deposit deposit) {
        return depositRepository.saveDeposit(deposit);
    }

    public void deleteDeposit(Long id) {
        depositRepository.deleteDepositById(id);
    }
}
