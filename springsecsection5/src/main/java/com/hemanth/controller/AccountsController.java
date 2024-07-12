package com.hemanth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {
    @GetMapping("/myAccounts")
    public String controller(){
        return "this is API for account controller";
    }
}
