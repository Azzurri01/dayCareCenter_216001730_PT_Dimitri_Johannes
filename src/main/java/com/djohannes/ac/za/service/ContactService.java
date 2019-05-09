package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Contact;

import java.util.Set;

public interface ContactService extends IService<Contact, String> {

    Set<Contact> getAll();
}
