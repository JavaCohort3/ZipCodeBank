package com.example.javacohort3.ZipCodeBank.services;

import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Deposit;
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
        Account account = accountRepository.findById(accountId);
        account.setBalance(account.getBalance() + deposit.getAmount());
        accountRepository.save(account);

        // binds account ID to deposit
        deposit.setAccount_id(accountId);
        return depositRepository.save(deposit);
    }

    public Deposit getDepositById(Long id) {
        return depositRepository.findById(id).orElse(null);
    }

    public ArrayList<Deposit> getAllDepositsForAccountId(Long accountId) {
        ArrayList<Deposit>
        return new ArrayList<>();
    }

    public Deposit updateDeposit(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    public void deleteDeposit(Long id) {
        depositRepository.deleteById(id);
    }
}
