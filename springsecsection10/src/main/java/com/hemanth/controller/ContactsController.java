package com.hemanth.controller;

import com.hemanth.model.Contact;
import com.hemanth.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;//contact
    @PostMapping("/contact")
    @PreFilter("filterObject.contactName != 'Test'")
    public List<Contact> saveContactInquiryDetails(@RequestBody List<Contact> contacts) {
        Contact contact = contacts.get(0);
        contact.setContactId(serviceNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        contact = contactRepository.save(contact);
        List<Contact> returnContacts = new ArrayList<>();
        returnContacts.add(contact);
        return returnContacts;
    }
    private  String serviceNumber(){
        Random random=new Random();
        int ranNum=random.nextInt(999999999 - 9999)+9999;
        return "SR"+ranNum;
    }
}
