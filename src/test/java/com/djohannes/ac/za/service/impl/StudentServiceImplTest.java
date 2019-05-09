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
    Address address = AddressFactory.getAddress("14", "Sentinel road");
    Contact pContact = ContactFactory.getContact("0824512653", "dimitri.johannes@gmail.com");
    Parent parent = ParentFactory.getParent(pName, pContact);

    private Student getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
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
    public void bUpdate()
    {
        String newStudentId = "123";
        Student updated = new Student.Builder().copy(getSaved()).id(newStudentId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newStudentId, updated.getId());
    }

    @Test
    public void cDelete()
    {
        Student saved = getSaved();
        this.repository.delete(saved.getId());
        eGetAll();
    }

    @Test
    public void dRead()
    {
        Student saved = getSaved();
        Student read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void eGetAll()
    {
        Set<Student> students = this.repository.getAll();
        System.out.println("In getall, all = " + students);
    }
}