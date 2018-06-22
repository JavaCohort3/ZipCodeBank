package com.example.javacohort3.ZipCodeBank.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String payee;
    private String nickname;
    private SimpleDateFormat creationDate = new SimpleDateFormat("YYYY-MM-DD");
    private SimpleDateFormat paymentDate = new SimpleDateFormat("YYYY-MM-DD");
    private SimpleDateFormat recurringDate = new SimpleDateFormat("DD");
    private SimpleDateFormat upcomingPaymentDate = new SimpleDateFormat("YYYY-MM-DD");
    private Double paymentAmount;
    private Long accountId;

    Bill() {}

    public Bill(Long id, String status, String payee, String nickname, SimpleDateFormat creationDate,
                SimpleDateFormat paymentDate, SimpleDateFormat recurringDate, SimpleDateFormat upcomingPaymentDate,
                Double paymentAmount, Long accountId) {
        this.id = id;
        this.status = status;
        this.payee = payee;
        this.nickname = nickname;
        this.creationDate = creationDate;
        this.paymentDate = paymentDate;
        this.recurringDate = recurringDate;
        this.upcomingPaymentDate = upcomingPaymentDate;
        this.paymentAmount = paymentAmount;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public SimpleDateFormat getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(SimpleDateFormat creationDate) {
        this.creationDate = creationDate;
    }

    public SimpleDateFormat getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(SimpleDateFormat paymentDate) {
        this.paymentDate = paymentDate;
    }

    public SimpleDateFormat getRecurringDate() {
        return recurringDate;
    }

    public void setRecurringDate(SimpleDateFormat recurringDate) {
        this.recurringDate = recurringDate;
    }

    public SimpleDateFormat getUpcomingPaymentDate() {
        return upcomingPaymentDate;
    }

    public void setUpcomingPaymentDate(SimpleDateFormat upcomingPaymentDate) {
        this.upcomingPaymentDate = upcomingPaymentDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", payee='" + payee + '\'' +
                ", nickname='" + nickname + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", recurringDate=" + recurringDate +
                ", upcomingPaymentDate='" + upcomingPaymentDate + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}
