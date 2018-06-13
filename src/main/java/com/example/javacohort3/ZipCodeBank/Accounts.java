package com.example.javacohort3.ZipCodeBank;

public class Accounts {

    private Long id;
    private Enum type;
    private String nickname;
    private Integer rewards;
    private Double balance;
    private Customer customer;

    public Accounts(){

    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRewards() {
        return rewards;
    }

    public void setRewards(Integer rewards) {
        this.rewards = rewards;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", type=" + type +
                ", nickname='" + nickname + '\'' +
                ", rewards=" + rewards +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}