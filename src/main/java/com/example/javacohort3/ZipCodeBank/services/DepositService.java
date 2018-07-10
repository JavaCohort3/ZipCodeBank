package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Deposit;
import com.example.javacohort3.ZipCodeBank.exceptions.ResourceNotFoundException;
import com.example.javacohort3.ZipCodeBank.repositories.AccountRepository;
import com.example.javacohort3.ZipCodeBank.repositories.DepositRepository;
import com.example.javacohort3.ZipCodeBank.util.Burn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // Verify
    public void verifyDepositById(Long id){
        if (depositRepository.findDepositById(id) == null) throw new ResourceNotFoundException(HttpStatus.NOT_FOUND," error fetching deposit with id ");
    }

    public void verifyAccountById(Long id) {
        if (accountRepository.findAccountById(id) == null) throw new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Account Not Found");
    }

    // Create
    public Deposit createDeposit(Deposit deposit, Long accountId){
        verifyDepositById(accountId);
        return depositRepository.save(deposit);
    }

    // Get
    public List<Deposit> getDepositsByAccountId(Long accountId) {
        verifyAccountById(accountId);

        ArrayList<Deposit> deposits = (ArrayList<Deposit>) depositRepository.findAll();
        verifyDepositById((long)(deposits.size()));
        deposits.removeIf(d -> !d.getPayeeId().equals(accountId));
        return deposits;
    }

    // Get By Account ID
    public Deposit getDepositById (Long id){
        verifyDepositById(id);
        return depositRepository.findDepositById(id);
    }

    // Update
    public Deposit updateDeposit(Deposit deposit){

        // verifies deposit before proceeding
        verifyDepositById(deposit.getId());

        // sets old deposit to variable
        Deposit oldDeposit = getDepositById(deposit.getId());

        // casts Burn.updateObjectFields return value to Deposit
        deposit = (Deposit) Burn.updateObjectFields(deposit, oldDeposit);

        // saves and returns customer
        return depositRepository.save(deposit);
    }

    // Delete
    public void deleteDepositById(Long id){
        verifyDepositById(id);
        depositRepository.deleteById(id);
    }
}
