package com.example.javacohort3.ZipCodeBank.domains;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String first_name;
    private String last_name;
    @ElementCollection
    @Transient
    private Set<Address> addresses = new TreeSet<>();

    public Customer(){}

    public Customer(Long id, String first_name, String last_name, Set<Address> addresses) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.addresses = addresses;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirst_name() { return first_name; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }
    public void setLast_name(String last_name) { this.last_name = last_name; }

    public Set<Address> getAddresses() { return addresses; }
    public void setAddresses(Set<Address> addresses) { this.addresses = addresses; }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
