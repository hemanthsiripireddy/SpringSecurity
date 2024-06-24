package com.hemanth.controller;

import com.hemanth.model.Loans;
import com.hemanth.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanRepository loanRepository;
    @GetMapping("/myLoans")
    @PostAuthorize("hasRole('USER')")
    public List<Loans> controller(@RequestParam int id){
        List<Loans> loans=loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if(loans.size()>0)
            return loans;
        return null;
    }
}
