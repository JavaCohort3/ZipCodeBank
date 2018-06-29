package com.example.javacohort3.ZipCodeBank.domains;

import javax.persistence.*;
import java.util.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    // @ElementCollection
    // @Transient
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    public Customer(){}

    public Customer(Long id, String firstName, String lastName, ArrayList<Address> addresses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        this.addresses = addresses;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public List<Address> getAddresses() { return addresses; }
    public void setAddresses(List<Address> addresses) { this.addresses = addresses; }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
