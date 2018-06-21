package io.elitejava3.BankAPI.repositories;

import io.elitejava3.BankAPI.domains.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findAccountById(Long id);
    void deleteAccountById(Long id);
}
