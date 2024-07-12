package com.hemanth.controller;

import com.hemanth.model.Customer;
import com.hemanth.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
@PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody  Customer customer){
    Customer savedCustomer =null;
    ResponseEntity reponse=null;

    try{
        String haspwd=passwordEncoder.encode(customer.getPwd());
        customer.setPwd(haspwd);
        customer.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
        savedCustomer=customerRepository.save(customer);

        if(savedCustomer.getId()>0){
            reponse=ResponseEntity.status(HttpStatus.CREATED).
                    body("given user details successfully registered");
        }

    }
    catch (Exception e){
        reponse=ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An exception Occurred due to "+e.getMessage());

    }
    return  reponse;

    }
@RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication){
        List<Customer> customerList=customerRepository.findByEmail(authentication.getName());
        if(customerList.size()>0)
            return customerList.get(0);
        return null;
    }
}
