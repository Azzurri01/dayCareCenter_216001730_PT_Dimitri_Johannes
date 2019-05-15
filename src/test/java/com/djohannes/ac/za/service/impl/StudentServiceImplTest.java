package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.StudentRepository;
import com.djohannes.ac.za.repository.impl.StudentRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class StudentServiceImplTest {

    private StudentRepository repository;
    private Student student;

    Name sName = NameFactory.getName("Naqeeb", "Johannes");
    Name pName = NameFactory.getName("Dimitri", "Johannes");
    Grade grade = GradeFactory.getGrade("R");
    Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
    Parent parent = ParentFactory.getParent(pName, pContact);

    private Student getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        Name name = NameFactory.getName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
        City city = CityFactory.getCity(name, population);
        Province province = ProvinceFactory.getProvince(name, population);
        Address address = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);

        this.repository = StudentRepositoryImpl.getRepository();
        this.student = StudentFactory.getStudent(sName, grade, "male", 5, address, parent);
    }

    @Test
    public void aCreate()
    {
        Student created = this.repository.create(this.student);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.student);
    }

    @Test
    public void cUpdate()
    {
        String newStudentId = "123";
        Student updated = new Student.Builder().copy(getSaved()).id(newStudentId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newStudentId, updated.getId());
    }

    @Test
    public void eDelete()
    {
        Student saved = getSaved();
        this.repository.delete(saved.getId());
        dGetAll();
    }

    @Test
    public void bRead()
    {
        Student saved = getSaved();
        Student read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void dGetAll()
    {
        Set<Student> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}