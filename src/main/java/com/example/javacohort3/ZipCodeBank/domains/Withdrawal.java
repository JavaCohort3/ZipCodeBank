package com.example.javacohort3.ZipCodeBank.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String transaction_date;
    private String status;
    private Long payer_id;
    private String medium;
    private Double amount;
    private String description;
    private Long accountId;

    public Withdrawal(){}

    public Withdrawal(Long id, String type, String transaction_date, String status, Long payer_id, String medium, Double amount, String description, Long account_id) {
        this.id = id;
        this.type = type;
        this.transaction_date = transaction_date;
        this.status = status;
        this.payer_id = payer_id;
        this.medium = medium;
        this.amount = amount;
        this.description = description;
        this.accountId = account_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(Long payer_id) {
        this.payer_id = payer_id;
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
                ", type='" + type + '\'' +
                ", transaction_date='" + transaction_date + '\'' +
                ", status='" + status + '\'' +
                ", payer_id=" + payer_id +
                ", medium='" + medium + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
