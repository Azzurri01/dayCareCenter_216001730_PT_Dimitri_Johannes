package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Parent;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParentFactoryTest {

    @Test
    public void getParent() {
        Name pName = NameFactory.getName("Dimitri", "Johannes");
        Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");

        Parent parent = ParentFactory.getParent(pName, pContact);
        Assert.assertEquals("Dimitri", parent.getName().getFirstName());
        Assert.assertEquals("Johannes", parent.getName().getLastName());
        Assert.assertEquals("0824512653", parent.getContact().getContactNo());
        Assert.assertEquals("dimitri.johannes@gmail.com", parent.getContact().getEmail());
    }
}