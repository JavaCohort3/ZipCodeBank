package com.example.javacohort3.ZipCodeBank.domains;

import com.example.javacohort3.ZipCodeBank.enums.Medium;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Deposit implements Serializable  {
    @Id
    private Long id;
    private String type;
    private TransactionType type;
    private String transaction_date;
    private String status;
    private Long payee_id;
    private Medium medium;
    private Double amount;
    private String description;

    @ManyToOne
    private Account account_id;

    public Deposit() {}

    public Deposit(Long id, String type, String transaction_date,
                   String status, Long payee_id, Medium medium,
                   Double amount, String description) {
        this.id = id;
        this.type = type;
        this.transaction_date = transaction_date;
        this.status = status;
        this.payee_id = payee_id;
        this.medium = medium;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getTransaction_date() { return transaction_date; }
    public void setTransaction_date(String transaction_date) { this.transaction_date = transaction_date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getPayee_id() { return payee_id; }
    public void setPayee_id(Long payee_id) { this.payee_id = payee_id; }

    public Medium getMedium() { return medium; }
      
    public void setMedium(Medium medium) { this.medium = medium; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Account getAccount_id() { return account_id; }
    public void setAccount_id(Account account_id) { this.account_id = account_id; }
}