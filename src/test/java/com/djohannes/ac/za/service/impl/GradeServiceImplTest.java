package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Grade;
import com.djohannes.ac.za.domain.*;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.GradeRepository;
import com.djohannes.ac.za.repository.impl.GradeRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class GradeServiceImplTest {

    private GradeRepository repository;
    private Grade grade;

    private Grade getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = GradeRepositoryImpl.getRepository();
        this.grade = GradeFactory.getGrade("R");
    }

    @Test
    public void aCreate()
    {
        Grade created = this.repository.create(this.grade);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.grade);
    }

    @Test
    public void cUpdate()
    {
        String newGradeId = "123";
        Grade updated = new Grade.Builder().copy(getSaved()).id(newGradeId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newGradeId, updated.getId());
    }

    @Test
    public void eDelete()
    {
        Grade saved = getSaved();
        this.repository.delete(saved.getId());
        dGetAll();
    }

    @Test
    public void bRead()
    {
        Grade saved = getSaved();
        Grade read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void dGetAll()
    {
        Set<Grade> grades = this.repository.getAll();
        System.out.println("In getall, all = " + grades);
    }
}