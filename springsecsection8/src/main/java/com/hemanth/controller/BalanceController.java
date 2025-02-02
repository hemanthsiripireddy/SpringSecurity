package com.hemanth.controller;

import com.hemanth.model.AccountTransactions;
import com.hemanth.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> controller(@RequestParam int id){

       List<AccountTransactions> accountTransactions=accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
       return accountTransactions;
    }
}
