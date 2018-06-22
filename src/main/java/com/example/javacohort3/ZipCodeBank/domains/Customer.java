package com.example.javacohort3.ZipCodeBank.domains;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

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
    private Set<Address> addresses = new TreeSet<>();

    public Customer(){}

    public Customer(Long id, String firstName, String lastName, Set<Address> addresses) {
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

    public Set<Address> getAddresses() { return addresses; }
    public void setAddresses(Set<Address> addresses) { this.addresses = addresses; }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
