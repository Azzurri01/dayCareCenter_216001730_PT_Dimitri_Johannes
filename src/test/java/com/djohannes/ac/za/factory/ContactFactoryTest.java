package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Contact;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactFactoryTest {

    @Test
    public void getContact()
    {
        Contact contact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
        Assert.assertEquals("0824512653", contact.getContactNo());
        Assert.assertEquals("dimitri.johannes@gmail.com", contact.getEmail());
    }
}