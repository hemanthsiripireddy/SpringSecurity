package com.hemanth.repository;

import com.hemanth.model.AccountTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions,Long> {
List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);
}
