package com.example.javacohort3.ZipCodeBank.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Customer implements Serializable {

    @Id
    private Long id;
    private Long accountId;
    private String first_name;
    private String last_name;
    @OneToMany
    @Column(name = "address")
    private Set<Address> address;

    public Customer() { }

    public Customer(Long id, Long accountId, String first_name, String last_name, Set<Address> address) {
        this.id = id;
        this.accountId = accountId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address=" + address +
                '}';
    }
}
