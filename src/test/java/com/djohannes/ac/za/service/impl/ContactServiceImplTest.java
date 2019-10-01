package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.ContactService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactServiceImplTest {

    @Autowired
    @Qualifier("ContactServiceImpl")
    private ContactService contactService;
    private Contact contact;
    private Set<Contact> contacts = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        contact = ContactFactory.getContact("0835133305", "fowzia.sinclair@gmail.com");
        contacts.add(contact);
    }

    @Test
    public void aCreate() {
        Contact conService = contactService.create(ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com"));
        System.out.println("Created contact: " + conService.getContactNo());
        Assert.assertNotNull(conService);
        contacts.add(conService);
    }

    @Test
    public void cUpdate() {
        String newContact = "Blue";
        Contact updated = contactService.update(new Contact.Builder().copy(contact).contactNo(newContact).build());
        System.out.println("In update, updated = " + updated);
        contacts.add(updated);
        Assert.assertEquals(updated.getId(), contactService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = contacts.size();
        System.out.println("Before deleting object: " + contact.getId());
        contacts.remove(contact.getId());
        System.out.println("After deleting object: " + contact.getId());
        Assert.assertEquals(total, contacts.size() - 1);
    }

    @Test
    public void bRead()
    {
        Contact readContact = contactService.read(contact.getId());
        System.out.println("readContact id: " + readContact.getId());
        System.out.println("contactService id: " + contactService.read(readContact.getId()));
        Assert.assertEquals(readContact.getId(), contactService.read(readContact.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Contact> contactList = contactService.getAll();
        System.out.println("Display all objects: " + contactList.toString());
        Assert.assertEquals(contactList.size(), contactService.getAll().size());
    }

}