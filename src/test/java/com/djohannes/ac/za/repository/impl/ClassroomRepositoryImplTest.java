package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Classroom;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.ClassroomRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassroomRepositoryImplTest {

    private ClassroomRepository repository;
    private Classroom classroom;

    private Classroom getSavedClassroom()
    {
        Set<Classroom> savedClassroom = this.repository.getAll();
        return  savedClassroom.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = ClassroomRepositoryImpl.getRepository();
        this.classroom = ClassroomFactory.getClassroom("2");
    }

    @Test
    public void aCreate()
    {
        Classroom createdClassroom = this.repository.create(this.classroom);
        System.out.println("Create method called: Created classroom = " + this.classroom);
        eGetAll();
        Assert.assertSame(createdClassroom, this.classroom);
    }

    @Test
    public void bRead()
    {
        Classroom savedClassroom = getSavedClassroom();
        System.out.println("Read method call 1: Reading classroomID = " + savedClassroom.getId());
        Classroom readClassroom = this.repository.read(savedClassroom.getId());
        System.out.println("Read method call 2: Reading read = " + savedClassroom.getId());
        eGetAll();
        Assert.assertSame(savedClassroom, readClassroom);
    }

    @Test
    public void cUpdate()
    {
        String newId = "112";
        Classroom streetNo = new Classroom.Builder().copy(getSavedClassroom()).id(newId).build();
        System.out.println("In update, about_to_updated = " + classroom);
        Classroom updated = this.repository.update(classroom);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId().toString());;
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Classroom savedClassroom = getSavedClassroom();
        this.repository.delete(savedClassroom.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Classroom> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}