package io.elitejava3.BankAPI.repositories;


import io.elitejava3.BankAPI.domains.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {

}
