package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Contact;

import java.util.Set;

public interface ContactRepository extends IRepository<Contact, String>
{
    Set<Contact> getAll();
}