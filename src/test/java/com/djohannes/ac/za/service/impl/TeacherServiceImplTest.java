package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Name;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.TeacherRepository;
import com.djohannes.ac.za.repository.impl.TeacherRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class TeacherServiceImplTest {

    private TeacherRepository repository;
    private Teacher teacher;

    Name name = NameFactory.getName("Fowzia", "Johannes");
    Contact contact = ContactFactory.getContact("0835133305", "fowzia.johannes@gmail.com");

    private Teacher getSaved(){
        return this.repository.getAll().iterator().next();
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
        Teacher created = this.repository.create(this.teacher);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.teacher);
    }

    @Test
    public void bUpdate()
    {
        String newTeacherId = "123";
        Teacher updated = new Teacher.Builder().copy(getSaved()).id(newTeacherId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newTeacherId, updated.getId());
    }

    @Test
    public void cDelete()
    {
        Teacher saved = getSaved();
        this.repository.delete(saved.getId());
        eGetAll();
    }

    @Test
    public void dRead()
    {
        Teacher saved = getSaved();
        Teacher read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void eGetAll()
    {
        Set<Teacher> teachers = this.repository.getAll();
        System.out.println("In getall, all = " + teachers);
    }
}