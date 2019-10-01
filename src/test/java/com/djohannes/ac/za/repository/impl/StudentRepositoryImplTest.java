/*package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.StudentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentRepositoryImplTest {

    private StudentRepository repository;
    private Student student;

    Name sName = NameFactory.getName("Naqeeb", "Johannes");
    Name pName = NameFactory.getName("Dimitri", "Johannes");
    Grade grade = GradeFactory.getGrade("R");
    Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
    Parent parent = ParentFactory.getParent(pName, pContact);

    private Student getSavedStudent()
    {
        Set<Student> savedStudents = this.repository.getAll();
        return  savedStudents.iterator().next();
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
        Student createdStudent = this.repository.create(this.student);
        System.out.println("Create method called: Created student = " + this.student);
        dGetAll();
        Assert.assertSame(createdStudent, this.student);
    }

    @Test
    public void bRead()
    {
        Student savedStudent = getSavedStudent();
        System.out.println("Read method call 1: Reading studentID = " + savedStudent.getId());
        Student readStudent = this.repository.read(savedStudent.getId());
        System.out.println("Read method call 2: Reading read = " + savedStudent.getId());
        dGetAll();
        Assert.assertSame(savedStudent, readStudent);
}

    @Test
    public void cUpdate()
    {
        Name name = NameFactory.getName("Heideveld");
        Population population = PopulationFactory.getTotal(100000);
        Suburb suburb = SuburbFactory.getSuburb("7764", name, population);
        City city = CityFactory.getCity(name, population);
        Province province = ProvinceFactory.getProvince(name, population);
        Address add = AddressFactory.getAddress("14", "Sentinel Road", suburb, city, province);

        Student newAddress = new Student.Builder().copy(getSavedStudent()).address(add).build();
        System.out.println("In update, about_to_updated = " + newAddress);
        Student updated = this.repository.update(newAddress);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newAddress, updated);
        dGetAll();
    }

    @Test
    public void eDelete()
    {
        Student savedStudent = getSavedStudent();
        this.repository.delete(savedStudent.getId());
        dGetAll();
    }

    @Test
    public void dGetAll()
    {
        Set<Student> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}*/