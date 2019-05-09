package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.factory.ContactFactory;
import com.djohannes.ac.za.repository.ContactRepository;
import com.djohannes.ac.za.repository.impl.ContactRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class ContactServiceImplTest {

    private ContactRepository repository;
    private Contact contact;

    private Contact getSaved()
    {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = ContactRepositoryImpl.getRepository();
        this.contact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
    }

    @Test
    public void aCreate()
    {
        Contact created = this.repository.create(this.contact);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.contact);
    }

    @Test
    public void bUpdate()
    {
        String newContactId = "123";
        Contact updated = new Contact.Builder().copy(getSaved()).id(newContactId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newContactId, updated.getId());
    }

    @Test
    public void cDelete()
    {
        Contact saved = getSaved();
        this.repository.delete(saved.getId());
        eGetAll();
    }

    @Test
    public void dRead()
    {
        Contact saved = getSaved();
        Contact read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void eGetAll()
    {
        Set<Contact> contacts = this.repository.getAll();
        System.out.println("In getall, all = " + contacts);
    }
}