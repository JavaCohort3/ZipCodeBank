package io.elitejava3.BankAPI.repositories;

import io.elitejava3.BankAPI.domains.Customer;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findCustomerById(Long id);
    void deleteCustomerById(Long id);
}
