package com.hemanth;

import com.hemanth.model.Customer;
import com.hemanth.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private CustomerRepository customerRepository;
@PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody  Customer customer){
    Customer savedCustomer =null;
    ResponseEntity reponse=null;

    try{
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
}
