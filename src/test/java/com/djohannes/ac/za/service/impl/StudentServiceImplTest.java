package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.service.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentServiceImplTest {

    @Autowired
    @Qualifier("StudentServiceImpl")
    private StudentService studentService;
    private Student student;
    private Set<Student> students = new HashSet<>();

    @Before
    public void setUp() throws Exception {
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
        students.add(student);
    }

    @Test
    public void aCreate() {
        Name sName1 = NameFactory.getName("Naqeeb", "Johannes");
        Name pName1 = NameFactory.getName("Dimitri", "Johannes");
        Grade grade1 = GradeFactory.getGrade("R");
        Contact pContact1 = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
        Parent parent1 = ParentFactory.getParent(pName1, pContact1);

        Name name1 = NameFactory.getName("Heideveld");
        Population population1 = PopulationFactory.getTotal(100000);
        Suburb suburb1 = SuburbFactory.getSuburb("7764", name1, population1);
        City city1 = CityFactory.getCity(name1, population1);
        Province province1 = ProvinceFactory.getProvince(name1, population1);
        Address address1 = AddressFactory.getAddress("14", "Sentinel Road", suburb1, city1, province1);

        Student stuService = StudentFactory.getStudent(sName1, grade1, "male", 5, address1, parent1);

        System.out.println("Created student: " + stuService.getName());
        Assert.assertNotNull(stuService);
        students.add(stuService);
    }

    @Test
    public void cUpdate() {
        Name name1 = NameFactory.getName("Hanover Park");
        Population population1 = PopulationFactory.getTotal(100000);
        Suburb suburb1 = SuburbFactory.getSuburb("7785", name1, population1);
        City city1 = CityFactory.getCity(name1, population1);
        Province province1 = ProvinceFactory.getProvince(name1, population1);
        Address newAddress = AddressFactory.getAddress("9", "Palm", suburb1, city1, province1);

        Student updated = studentService.update(new Student.Builder().copy(student).address(newAddress).build());
        System.out.println("In update, updated = " + updated);
        students.add(updated);
        Assert.assertEquals(updated.getId(), studentService.read(updated.getId()));
    }

    @Test
    public void eDelete() {
        int total = students.size();
        System.out.println("Before deleting object: " + student.getId());
        students.remove(student.getId());
        System.out.println("After deleting object: " + student.getId());
        Assert.assertEquals(total, students.size() - 1);
    }

    @Test
    public void bRead()
    {
        Student readStudent = studentService.read(student.getId());
        System.out.println("readStudent id: " + readStudent.getId());
        System.out.println("studentService id: " + studentService.read(readStudent.getId()));
        Assert.assertEquals(readStudent.getId(), studentService.read(readStudent.getId()));
    }

    @Test
    public void dGetAll()
    {
        List<Student> studentList = studentService.getAll();
        System.out.println("Display all objects: " + studentList.toString());
        Assert.assertEquals(studentList.size(), studentService.getAll().size());
    }

}