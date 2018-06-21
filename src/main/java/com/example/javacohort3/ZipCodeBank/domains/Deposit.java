package com.example.javacohort3.ZipCodeBank.domains;

import com.example.javacohort3.ZipCodeBank.enums.Medium;

import com.example.javacohort3.ZipCodeBank.enums.TransactionStatus;
import com.example.javacohort3.ZipCodeBank.enums.TransactionType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Deposit {
    @Id
    private Long id;
    private TransactionType type;
    private Date transaction_date;
    private TransactionStatus status;
    @ManyToOne
    private Customer payee_id;
    private Medium medium;
    private Double amount;
    private String description;
    @ManyToOne
    private Account accountId;


    public Deposit() {
    }

    public Deposit(Long id, TransactionType type, Date transaction_date, TransactionStatus status, Customer payee_id,
                   Medium medium, Double amount, String description, Account accountId) {
        this.id = id;
        this.type = type;
        this.transaction_date = transaction_date;
        this.status = status;
        this.payee_id = payee_id;
        this.medium = medium;
        this.amount = amount;
        this.description = description;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Customer getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(Customer payee_id) {
        this.payee_id = payee_id;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", type=" + type +
                ", transaction_date=" + transaction_date +
                ", status=" + status +
                ", payee_id=" + payee_id +
                ", medium=" + medium +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", accountId=" + accountId +
                '}';

    }
}