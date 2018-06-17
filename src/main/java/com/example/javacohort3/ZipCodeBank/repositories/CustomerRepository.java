package com.example.javacohort3.ZipCodeBank.repositories;

import com.example.javacohort3.ZipCodeBank.domains.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
//  all except verify

    Customer createCustomer(Customer customer);
    Customer getCustomerByAccountId(Long id);
    ArrayList<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long id);
    

}
