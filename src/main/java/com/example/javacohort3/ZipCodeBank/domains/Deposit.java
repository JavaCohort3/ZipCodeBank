package com.example.javacohort3.ZipCodeBank.domains;

public class Deposit {
    private Long id;
    private Enum type;
    private String transaction_date;
    private String status;
    private Long payee_id;
    private Enum medium;
    private Double amount;
    private String description;
    private Long account_id;

    public Deposit() {}

    public Deposit(Long id, Enum type, String transaction_date, String status, Long payee_id, Enum medium, Double amount, String description) {
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

    public Enum getType() { return type; }
    public void setType(Enum type) { this.type = type; }

    public String getTransaction_date() { return transaction_date; }
    public void setTransaction_date(String transaction_date) { this.transaction_date = transaction_date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getPayee_id() { return payee_id; }
    public void setPayee_id(Long payee_id) { this.payee_id = payee_id; }

    public Enum getMedium() { return medium; }
    public void setMedium(Enum medium) { this.medium = medium; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getAccount_id() { return account_id; }
    public void setAccount_id(Long account_id) { this.account_id = account_id; }
}