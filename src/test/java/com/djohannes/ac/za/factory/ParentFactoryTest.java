package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Parent;
import org.junit.Assert;
import org.junit.Test;

public class ParentFactoryTest {

    @Test
    public void getParent() {
        Name pName = NameFactory.getName("Dimitri", "Johannes");
        Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");

        Parent parent = ParentFactory.getParent(pName, pContact);
        Assert.assertNotNull(parent.getId());
        Assert.assertEquals(pName.getFirstName(), parent.getName().getFirstName());
        Assert.assertEquals(pName.getLastName(), parent.getName().getLastName());
        Assert.assertEquals(pContact.getContactNo(), parent.getContact().getContactNo());
        Assert.assertEquals(pContact.getEmail(), parent.getContact().getEmail());
    }
}