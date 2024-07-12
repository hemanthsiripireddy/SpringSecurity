package com.hemanth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController {
    @GetMapping("/contacts")
    public String controller(){
        return "this is API for Contacts controller";
    }
}
