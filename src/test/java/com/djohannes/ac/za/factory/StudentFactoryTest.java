package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.*;
import org.junit.Assert;
import org.junit.Test;

public class StudentFactoryTest {

    @Test
    public void getStudent()
    {
        Name sName = NameFactory.getName("Naqeeb", "Johannes");
        Name pName = NameFactory.getName("Dimitri", "Johannes");
        Grade grade = GradeFactory.getGrade("R");
        Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
        Parent parent = ParentFactory.getParent(pName, pContact);

        Name name = NameFactory.getName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
        City city = CityFactory.getCity(name, population);
        Province province = ProvinceFactory.getProvince(name, population);
        Address address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);

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