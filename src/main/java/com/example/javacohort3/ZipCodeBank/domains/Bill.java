package com.example.javacohort3.ZipCodeBank.domains;

public class Bill {
    private Long id;
    private String status;
    private String payee;
    private String nickname;
    private String creation_date;
    private String payment_date;
    private String recurring_date;
    private String upcoming_payment;
    private Double payment_amount;
    private String account_id;

    public Bill() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPayee() { return payee; }
    public void setPayee(String payee) { this.payee = payee; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getCreation_date() { return creation_date; }
    public void setCreation_date(String creation_date) { this.creation_date = creation_date; }

    public String getPayment_date() { return payment_date; }
    public void setPayment_date(String payment_date) { this.payment_date = payment_date; }

    public String getRecurring_date() { return recurring_date; }
    public void setRecurring_date(String recurring_date) { this.recurring_date = recurring_date; }

    public String getUpcoming_payment() { return upcoming_payment; }
    public void setUpcoming_payment(String upcoming_payment) { this.upcoming_payment = upcoming_payment; }

    public Double getPayment_amount() { return payment_amount; }
    public void setPayment_amount(Double payment_amount) { this.payment_amount = payment_amount; }

    public String getAccount_id() { return account_id; }
    public void setAccount_id(String account_id) { this.account_id = account_id; }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", payee='" + payee + '\'' +
                ", nickname='" + nickname + '\'' +
                ", creation_date='" + creation_date + '\'' +
                ", payment_date='" + payment_date + '\'' +
                ", recurring_date='" + recurring_date + '\'' +
                ", upcoming_payment='" + upcoming_payment + '\'' +
                ", payment_amount=" + payment_amount +
                ", account_id='" + account_id + '\'' +
                '}';
    }
}
