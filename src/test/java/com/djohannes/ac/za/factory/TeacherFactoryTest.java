package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Teacher;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherFactoryTest {

    @Test
    public void getTeacher()
    {
        Name tName = NameFactory.getName("Fowzia", "Johannes");
        Contact tContact = ContactFactory.getContact("0835133305", "fowzia.johannes@gmail.com");

        Teacher teacher = TeacherFactory.getTeacher("123", tName, tContact);
        Assert.assertEquals("123", teacher.getId());
        Assert.assertEquals("Fowzia", teacher.getName().getFirstName());
        Assert.assertEquals("Johannes", teacher.getName().getLastName());
        Assert.assertEquals("0835133305", teacher.getContact().getContactNo());
        Assert.assertEquals("fowzia.johannes@gmail.com", teacher.getContact().getEmail());
    }
}