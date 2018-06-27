package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Deposit;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepositService {
    private DepositRepository depositRepository;
    private AccountRepository accountRepository;

    @Autowired
    public DepositService(DepositRepository depositRepository, AccountRepository accountRepository) {
        this.depositRepository = depositRepository;
        this.accountRepository = accountRepository;
    }

    public void verifyDepositById(Long id){
        if (depositRepository.findDepositById(id) == null) throw new ResourceNotFoundException();
    }

    public void verifyAccountById(Long id) {
        if (accountRepository.findAccountById(id) == null) throw new ResourceNotFoundException();
    }

    public Deposit createDeposit(Deposit deposit){
        return depositRepository.save(deposit);
    }

    public List<Deposit> getDepositsByAccountId(Long accountId) {
        ArrayList<Deposit> deposits = (ArrayList<Deposit>) depositRepository.findAll();
        deposits.removeIf(d -> !d.getPayeeId().equals(accountId));
        return deposits;
    }

    public Deposit getDepositById (Long id){
        return depositRepository.findDepositById(id);
    }

    public Deposit updateDeposit(Deposit deposit){
        return depositRepository.save(deposit);
    }
}
