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

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    AccountService accountService;


    public void verifyDeposit(Long depositId) {
        if (depositRepository.findById(depositId).orElse(null) == null) throw new ResourceNotFoundException();
    }

    public Deposit createDepositByFromAccountId(Deposit deposit, Long accountId) {

        if (accountRepository.existsByAccountId(accountId)) {
            return depositRepository.save(deposit);
        }else {
            throw new ResourceNotFoundException();
        }
    }

    public Deposit getDepositById(Long id) {
        return depositRepository.findById(id).orElse(null);
    }

    public List<Deposit> getAllDepositsForAccountId(Long accountId) {

        List<Deposit> depositList = new ArrayList<>();
        depositRepository.findByAccountId(accountId).forEach(depositList::add);
        return depositList;
    }

    public Deposit updateDeposit(Deposit deposit, Long accountId) {
        return depositRepository.save(deposit);
    }

    public void deleteDeposit(Long accountId) {
        depositRepository.deleteById(accountId);

    }
}
