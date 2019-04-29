package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Grade;
import com.djohannes.ac.za.domain.Address;
import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.domain.Parent;
import com.djohannes.ac.za.domain.Student;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentFactoryTest {

    @Test
    public void getStudent()
    {
        Name sName = NameFactory.getName("Naqeeb", "Johannes");
        Name pName = NameFactory.getName("Dimitri", "Johannes");
        Grade grade = GradeFactory.getGrade("R");
        Address address = AddressFactory.getAddress("14", "Sentinel road", "Heideveld");
        Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
        Parent parent = ParentFactory.getParent(pName, pContact);

        Student student = StudentFactory.getStudent("123", sName, grade, "male", 5, address, parent);
        Assert.assertEquals("123", student.getId());
        Assert.assertEquals("Naqeeb", student.getName().getFirstName());
        Assert.assertEquals("Johannes", student.getName().getLastName());
        Assert.assertEquals("R", student.getGrade().getGrade());
        Assert.assertEquals("male", student.getGender());
        Assert.assertEquals(5, student.getAge());
        Assert.assertEquals("14", student.getAddress().getNo());
        Assert.assertEquals("Sentinel road", student.getAddress().getStreet());
        Assert.assertEquals("Heideveld", student.getAddress().getSuburb());
        Assert.assertEquals("Dimitri", student.getParent().getName().getFirstName());
        Assert.assertEquals("Johannes", student.getParent().getName().getLastName());
    }
}