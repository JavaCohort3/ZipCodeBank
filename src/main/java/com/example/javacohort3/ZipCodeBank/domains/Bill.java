package com.example.javacohort3.ZipCodeBank.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Bill {

    @Id
    private Long id;
    private String payee;
    private String  nickname;
    private String creation_date;
    private Integer payment_date;
    private Integer recurring_date;
    private String upcoming_payment_date;
    private Double payment_amount;
    @Column(name = "Account_Id")
    private Long account_id;


    public Bill() {
    }

    public Bill(Long id, String payee, String nickname, String creation_date, Integer payment_date, Integer recurring_date, String upcoming_payment_date, Double payment_amount, Long account_id) {
        this.id = id;
        this.payee = payee;
        this.nickname = nickname;
        this.creation_date = creation_date;
        this.payment_date = payment_date;
        this.recurring_date = recurring_date;
        this.upcoming_payment_date = upcoming_payment_date;
        this.payment_amount = payment_amount;
        this.account_id = account_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public Integer getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Integer payment_date) {
        this.payment_date = payment_date;
    }

    public Integer getRecurring_date() {
        return recurring_date;
    }

    public void setRecurring_date(Integer recurring_date) {
        this.recurring_date = recurring_date;
    }

    public String getUpcoming_payment_date() {
        return upcoming_payment_date;
    }

    public void setUpcoming_payment_date(String upcoming_payment_date) {
        this.upcoming_payment_date = upcoming_payment_date;
    }

    public Double getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(Double payment_amount) {
        this.payment_amount = payment_amount;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", payee='" + payee + '\'' +
                ", nickname='" + nickname + '\'' +
                ", creation_date='" + creation_date + '\'' +
                ", payment_date=" + payment_date +
                ", recurring_date=" + recurring_date +
                ", upcoming_payment_date='" + upcoming_payment_date + '\'' +
                ", payment_amount=" + payment_amount +
                ", account_id=" + account_id +
                '}';
    }
}
