package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String>
{
    //Set<Contact> getAll();
}