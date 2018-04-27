package com.spring.restapi.repositories;

import com.spring.restapi.model.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContactRepository extends CrudRepository<Contact, String> {

    @Override
    Optional<Contact> findById(String id);

    @Override
    void delete(Contact deleted);
}
