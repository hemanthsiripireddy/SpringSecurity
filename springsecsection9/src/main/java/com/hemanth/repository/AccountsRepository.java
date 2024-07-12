package com.hemanth.repository;

import com.hemanth.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts,Long> {

    Accounts findByCustomerId(int customerId);

}
