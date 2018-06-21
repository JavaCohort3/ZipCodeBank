package com.example.javacohort3.ZipCodeBank.domains;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    private Long id;
    @ManyToOne
    private Account accountId;
    private String firstName;
    private String lastName;
    @ManyToOne
    private Address address;

    public Customer() { }

    public Customer(String firstName){
        this.firstName = firstName;
    }

    public Customer(Long id){
        this.id = id;
    }

    public Customer(Long id,String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(Long id, Account accountId, String firstName, String lastName) {
        this.id = id;
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(Long id, Account accountId, String firstName, String lastName, Address address) {
        this.id = id;
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
