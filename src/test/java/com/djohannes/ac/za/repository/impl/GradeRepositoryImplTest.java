package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Evaluation;
import com.djohannes.ac.za.domain.Grade;
import com.djohannes.ac.za.factory.*;
import com.djohannes.ac.za.repository.GradeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GradeRepositoryImplTest {

    private GradeRepository repository;
    private Grade grade;

    Evaluation evaluation = EvaluationFactory.getEvaluation(5);

    private Grade getSavedGrade()
    {
        Set<Grade> savedGrade = this.repository.getAll();
        return  savedGrade.iterator().next();
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
        Grade createdGrade = this.repository.create(this.grade);
        System.out.println("Create method called: Created grade = " + this.grade);
        eGetAll();
        Assert.assertSame(createdGrade, this.grade);
    }

    @Test
    public void bRead()
    {
        Grade savedGrade = getSavedGrade();
        System.out.println("Read method call 1: Reading gradeID = " + savedGrade.getId());
        Grade readGrade = this.repository.read(savedGrade.getId());
        System.out.println("Read method call 2: Reading read = " + savedGrade.getId());
        eGetAll();
        Assert.assertSame(savedGrade, readGrade);
    }

    @Test
    public void cUpdate()
    {
        String grade = "e";
        Grade newGrade = new Grade.Builder().copy(getSavedGrade()).getGrade(grade).build();
        System.out.println("In update, about_to_updated = " + newGrade);
        Grade updated = this.repository.update(newGrade);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newGrade, updated);
        eGetAll();
    }

    @Test
    public void dDelete()
    {
        Grade savedGrade = getSavedGrade();
        this.repository.delete(savedGrade.getId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Grade> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}