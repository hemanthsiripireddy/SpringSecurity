package com.hemanth.controller;

import com.hemanth.model.Accounts;
import com.hemanth.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountsController {
    @Autowired
    private AccountsRepository accountsRepository;
    @GetMapping("/myAccount")
    public Accounts controller(@RequestParam int id){

       return accountsRepository.findByCustomerId(id);
    }
}
