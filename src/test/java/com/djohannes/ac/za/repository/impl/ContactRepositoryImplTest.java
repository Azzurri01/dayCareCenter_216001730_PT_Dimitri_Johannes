package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.factory.ContactFactory;
import com.djohannes.ac.za.repository.ContactRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactRepositoryImplTest {

    private ContactRepository repository;
    private Contact contact;

    private Contact getSavedContact()
    {
        Set<Contact> savedContact = this.repository.getAll();
        return  savedContact.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = ContactRepositoryImpl.getRepository();
        this.contact = ContactFactory.getContact("14", "Sentinel Road");
    }

    @Test
    public void aCreate()
    {
        Contact createdContact = this.repository.create(this.contact);
        System.out.println("Create method called: Created contact = " + this.contact);
        eGetAll();
        Assert.assertSame(createdContact, this.contact);
    }

    @Test
    public void bRead()
    {
        Contact savedContact = getSavedContact();
        System.out.println("Read method call 1: Reading contactID = " + savedContact.getId());
        Contact readContact = this.repository.read(savedContact.getId());
        System.out.println("Read method call 2: Reading read = " + savedContact.getId());
        eGetAll();
        Assert.assertSame(savedContact, readContact);
    }

    @Test
    public void cUpdate()
    {
        String newno = "0824512655";
        Contact contactno = new Contact.Builder().copy(getSavedContact()).contactNo(newno).build();
        System.out.println("In update, about_to_updated = " + contact);
        Contact updated = this.repository.update(contact);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newno, updated.getContactNo().toString());
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Contact savedContact = getSavedContact();
        this.repository.delete(savedContact.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Contact> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}