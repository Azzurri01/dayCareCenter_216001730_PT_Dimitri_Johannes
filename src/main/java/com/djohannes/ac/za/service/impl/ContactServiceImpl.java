package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.repository.ContactRepository;
import com.djohannes.ac.za.repository.impl.ContactRepositoryImpl;
import com.djohannes.ac.za.service.ContactService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ContactServiceImpl")
public class ContactServiceImpl implements ContactService {

    private static ContactServiceImpl service = null;

    @Autowired
    @Qualifier("ContactMemory")
    private ContactRepository repository;

    private ContactServiceImpl() {
        this.repository = ContactRepositoryImpl.getRepository();
    }

    public static ContactServiceImpl getService(){
        if (service == null) service = new ContactServiceImpl();
        return service;
    }

    @Override
    public Contact create(Contact contact) {
        return this.repository.create(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return this.repository.update(contact);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Contact read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Contact> getAll() {
        return this.repository.getAll();
    }
}