package com.example.javacohort3.ZipCodeBank.domains;

import com.example.javacohort3.ZipCodeBank.enums.TransactionMedium;
import com.example.javacohort3.ZipCodeBank.enums.TransactionStatus;
import com.example.javacohort3.ZipCodeBank.enums.TransactionType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TransactionType type;
    private String transactionDate;
    private TransactionStatus status;
    private Long payerId;
    private TransactionMedium medium;
    private Double amount;
    private String description;

    public Withdrawal(){}

    public Withdrawal(Long id, TransactionType type, String transactionDate, TransactionStatus status, Long payerId, TransactionMedium medium, Double amount, String description) {
        this.id = id;
        this.type = type;
        this.transactionDate = transactionDate;
        this.status = status;
        this.payerId = payerId;
        this.medium = medium;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TransactionType getType() { return type; }
    public void setType(TransactionType type) { this.type = type; }

    public String getTransactionDate() { return transactionDate; }
    public void setTransactionDate(String transactionDate) { this.transactionDate = transactionDate; }

    public TransactionStatus getStatus() { return status; }
    public void setStatus(TransactionStatus status) { this.status = status; }

    public Long getPayerId() { return payerId; }
    public void setPayerId(Long payerId) { this.payerId = payerId; }

    public TransactionMedium getMedium() { return medium; }
    public void setMedium(TransactionMedium medium) { this.medium = medium; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", status='" + status + '\'' +
                ", payerId=" + payerId +
                ", medium='" + medium + '\'' +
                ", amount=" + amount +
                ", description='" + description +
                '}';
    }
}
