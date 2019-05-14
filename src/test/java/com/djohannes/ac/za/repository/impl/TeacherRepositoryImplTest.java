package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Contact;
import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.Teacher;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.TeacherRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TeacherRepositoryImplTest {

    private TeacherRepository repository;
    private Teacher teacher;

    Name name = NameFactory.getName("Fowzia", "Johannes");
    Contact contact = ContactFactory.getContact("0835133305", "fowzia.johannes@gmail.com");

    private Teacher getSavedTeacher()
    {
        Set<Teacher> savedTeacher = this.repository.getAll();
        return  savedTeacher.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = TeacherRepositoryImpl.getRepository();
        this.teacher = TeacherFactory.getTeacher(name, contact);
    }

    @Test
    public void aCreate()
    {
        Teacher createdTeacher = this.repository.create(this.teacher);
        System.out.println("Create method called: Created teacher = " + this.teacher);
        eGetAll();
        Assert.assertSame(createdTeacher, this.teacher);
    }

    @Test
    public void bRead()
    {
        Teacher savedTeacher = getSavedTeacher();
        System.out.println("Read method call 1: Reading teacherID = " + savedTeacher.getId());
        Teacher readTeacher = this.repository.read(savedTeacher.getId());
        System.out.println("Read method call 2: Reading read = " + savedTeacher.getId());
        eGetAll();
        Assert.assertSame(savedTeacher, readTeacher);
    }

    @Test
    public void cUpdate()
    {
        Contact con = ContactFactory.getContact("8787226364", "teacher.school@ac.za");
        Teacher newTel = new Teacher.Builder().copy(getSavedTeacher()).contact(con).build();
        System.out.println("In update, about_to_updated = " + newTel);
        Teacher updated = this.repository.update(newTel);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newTel, updated);
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Teacher savedTeacher = getSavedTeacher();
        this.repository.delete(savedTeacher.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Teacher> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}