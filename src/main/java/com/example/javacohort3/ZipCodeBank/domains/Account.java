package com.example.javacohort3.ZipCodeBank.domains;

import com.example.javacohort3.ZipCodeBank.enums.AccountType;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private AccountType type;//ENUM serialized as a string
    private String nickname;
    private Integer rewards;
    private Double balance;
    @ManyToOne
    private Customer customer;

    public Account(){}

    public Account(Long id, AccountType type, String nickname, Integer rewards, Double balance, Customer customer) {
        this.id = id;
        this.type = type;
        this.nickname = nickname;
        this.rewards = rewards;
        this.balance = balance;
        this.customer = customer;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public AccountType getType() { return type; }
    public void setType(AccountType type) {
        this.type = type;
    }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRewards() { return rewards; }
    public void setRewards(Integer rewards) {
        this.rewards = rewards;
    }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", type=" + type +
                ", nickname='" + nickname + '\'' +
                ", rewards=" + rewards +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}
