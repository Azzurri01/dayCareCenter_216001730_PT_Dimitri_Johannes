package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Teacher;
import org.junit.Assert;
import org.junit.Test;

public class TeacherFactoryTest {

    @Test
    public void getTeacher()
    {
        Name tName = NameFactory.getName("Fowzia", "Johannes");
        Contact tContact = ContactFactory.getContact("0835133305", "fowzia.johannes@gmail.com");

        Teacher teacher = TeacherFactory.getTeacher(tName, tContact);
        Assert.assertNotNull(teacher.getId());
        Assert.assertEquals(tName.getFirstName(), teacher.getName().getFirstName());
        Assert.assertEquals(tName.getLastName(), teacher.getName().getLastName());
        Assert.assertEquals(tContact.getContactNo(), teacher.getContact().getContactNo());
        Assert.assertEquals(tContact.getEmail(), teacher.getContact().getEmail());
    }
}