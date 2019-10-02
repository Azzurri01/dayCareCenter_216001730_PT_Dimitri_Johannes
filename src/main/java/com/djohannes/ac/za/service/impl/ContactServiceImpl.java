package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.repository.ContactRepository;
import com.djohannes.ac.za.service.ContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ContactServiceImpl")
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository repository;

    @Override
    public Contact create(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Contact read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public List<Contact> getAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}