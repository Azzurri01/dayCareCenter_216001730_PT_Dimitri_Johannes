package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentFactoryTest {

    @Test
    public void getStudent()
    {
        //(String id, Name name, Grade grade, String gender, int age, Address address, Parent parent)

        Name sName = NameFactory.getName("Naqeeb", "Johannes");
        Name pName = NameFactory.getName("Dimitri", "Johannes");
        Grade grade = GradeFactory.getGrade("R");
        Address address = AddressFactory.getAddress("14", "Sentinel road", "Heideveld");
        Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
        Parent parent = ParentFactory.getParent(pName, pContact);

        Student student = StudentFactory.getStudent("123", sName, grade, "male", 5, address, parent);
        Assert.assertEquals("123", student.getId());
    }
}