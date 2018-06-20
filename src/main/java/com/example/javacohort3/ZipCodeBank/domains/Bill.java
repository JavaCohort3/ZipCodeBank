package com.example.javacohort3.ZipCodeBank.domains;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Bill {
    @Id
    private Long id;
    @ManyToOne
    private Customer  customerId;
    private String  nickname;
    private Date creation_date;
    private Date payment_date;
    private Date recurring_date;
    private Date upcoming_payment_date;
    private Double payment_amount;
    @ManyToOne
    private Account accountId;


    public Bill() {
    }

    public Bill(Long id, String nickname, Customer customerId, Date creation_date, Date payment_date, Date recurring_date, Date upcoming_payment_date, Double payment_amount, Account accountId) {
        this.id = id;
        this.customerId = customerId;
        this.nickname = nickname;
        this.creation_date = creation_date;
        this.payment_date = payment_date;
        this.recurring_date = recurring_date;
        this.upcoming_payment_date = upcoming_payment_date;
        this.payment_amount = payment_amount;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getPayee() {
        return customerId;
    }

    public void setPayee(Customer customerId) {
        this.customerId = customerId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public Date getRecurring_date() {
        return recurring_date;
    }

    public void setRecurring_date(Date recurring_date) {
        this.recurring_date = recurring_date;
    }

    public Date getUpcoming_payment_date() {
        return upcoming_payment_date;
    }

    public void setUpcoming_payment_date(Date upcoming_payment_date) {
        this.upcoming_payment_date = upcoming_payment_date;
    }

    public Double getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(Double payment_amount) {
        this.payment_amount = payment_amount;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", payee='" + customerId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", creation_date='" + creation_date + '\'' +
                ", payment_date=" + payment_date +
                ", recurring_date=" + recurring_date +
                ", upcoming_payment_date='" + upcoming_payment_date + '\'' +
                ", payment_amount=" + payment_amount +
                ", accountId=" + accountId +
                '}';
    }
}
