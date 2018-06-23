package com.example.javacohort3.ZipCodeBank.repositories;


import com.example.javacohort3.ZipCodeBank.domains.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findCustomerById(Long id);
    void deleteCustomerById(Long id);
}
