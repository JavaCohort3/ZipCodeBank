package com.example.javacohort3.ZipCodeBank.domains;

import com.example.javacohort3.ZipCodeBank.enums.Medium;
import com.example.javacohort3.ZipCodeBank.enums.TransactionStatus;
import com.example.javacohort3.ZipCodeBank.enums.TransactionType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Withdrawal {

    @Id
    private Long id;
    private TransactionType type;
    private Date transaction_date;
    private TransactionStatus status;
    @ManyToOne
    private Customer payer_id;
    private Medium medium;
    private Double amount;
    private String description;
    @ManyToOne
    private Account account_id;

    public Withdrawal(){

    }

    public Withdrawal(Long id, TransactionType type, Date transaction_date, TransactionStatus status, Customer payer_id, Medium medium, Double amount, String description, Account account_id) {
        this.id = id;
        this.type = type;
        this.transaction_date = transaction_date;
        this.status = status;
        this.payer_id = payer_id;
        this.medium = medium;
        this.amount = amount;
        this.description = description;
        this.account_id = account_id;
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

    public Customer getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(Customer payer_id) {
        this.payer_id = payer_id;
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

    public Account getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Account account_id) {
        this.account_id = account_id;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", transaction_date='" + transaction_date + '\'' +
                ", status='" + status + '\'' +
                ", payer_id=" + payer_id +
                ", medium='" + medium + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", account_id=" + account_id +
                '}';
    }
}
