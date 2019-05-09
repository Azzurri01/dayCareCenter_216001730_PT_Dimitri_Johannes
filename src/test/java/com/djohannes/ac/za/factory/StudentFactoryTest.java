package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Grade;
import com.djohannes.ac.za.domain.Address;
import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.domain.Parent;
import com.djohannes.ac.za.domain.Student;
import org.junit.Assert;
import org.junit.Test;

public class StudentFactoryTest {

    @Test
    public void getStudent()
    {
        Name sName = NameFactory.getName("Naqeeb", "Johannes");
        Name pName = NameFactory.getName("Dimitri", "Johannes");
        Grade grade = GradeFactory.getGrade("R");
        Address address = AddressFactory.getAddress("14", "Sentinel road");
        Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
        Parent parent = ParentFactory.getParent(pName, pContact);

        Student student = StudentFactory.getStudent(sName, grade, "male", 5, address, parent);
        Assert.assertNotNull(student.getId());
        Assert.assertEquals(sName.getFirstName(), student.getName().getFirstName());
        Assert.assertEquals(sName.getLastName(), student.getName().getLastName());
        Assert.assertEquals(grade.getGrade(), student.getGrade().getGrade());
        Assert.assertEquals("male", student.getGender());
        Assert.assertEquals(5, student.getAge());
        Assert.assertEquals(address.getNo(), student.getAddress().getNo());
        Assert.assertEquals(address.getStreet(), student.getAddress().getStreet());
        Assert.assertEquals(pName.getFirstName(), student.getParent().getName().getFirstName());
        Assert.assertEquals(pName.getLastName(), student.getParent().getName().getLastName());
    }
}