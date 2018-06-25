package com.example.javacohort3.ZipCodeBank.domains;

import com.example.javacohort3.ZipCodeBank.enums.TransactionMedium;
import com.example.javacohort3.ZipCodeBank.enums.TransactionStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TransactionMedium type;
    private TransactionStatus types;
    private String transactionDate;
    private String status;
    private Long payerId;
    private String medium;
    private Double amount;
    private String description;
    private Long accountId;

    public Withdrawal() {
    }

    public Withdrawal(Long id, TransactionMedium type, TransactionStatus types, String transactionDate, String status, Long payerId, String medium, Double amount, String description, Long accountId) {
        this.id = id;
        this.type = type;
        this.types = types;
        this.transactionDate = transactionDate;
        this.status = status;
        this.payerId = payerId;
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

    public TransactionMedium getType() {
        return type;
    }

    public void setType(TransactionMedium type) {
        this.type = type;
    }

    public TransactionStatus getTypes() {
        return types;
    }

    public void setTypes(TransactionStatus types) {
        this.types = types;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "id=" + id +
                ", type=" + type +
                ", types=" + types +
                ", transactionDate='" + transactionDate + '\'' +
                ", status='" + status + '\'' +
                ", payerId=" + payerId +
                ", medium='" + medium + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}