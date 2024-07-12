package com.hemanth.repository;

import com.hemanth.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Long> {
}
